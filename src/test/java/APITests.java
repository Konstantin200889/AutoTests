import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.example.api.TestOrderFunction;
import org.example.dto.TestOrder;
import org.example.dto.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class APITests {

    // параметризированный тест (подгружаем данные из файла test.csv и проверяем корректность заполнение полей при помощи Assertions)
    @ParameterizedTest
    @CsvFileSource(resources = "/test.csv", useHeadersInDisplayName = true)
    void testWithCsvFileSourceAndHeaders(String Login, String Password, String Role) {
        String a = Login + " " + Password + " " + Role;
        System.out.println(a);
        Assertions.assertNotNull(Login);
        Assertions.assertNotNull(Password);
        Assertions.assertNotNull(Role);
        Assertions.assertNotEquals(" ", Login);
        Assertions.assertNotEquals(" ", Password);
        Assertions.assertNotEquals(" ", Role);
    }


    private String SwaggerTestUrl = "*****";
    private final static String ORDER_OPEN_STATUS = "OPEN";

    // проверка статуса определенного заказа
    @Test
    public void getTestOrderDataAndCheckId() {
        when().
                get(SwaggerTestUrl + "/test-orders/{id}", 4).
                then().
                statusCode(200).
                body("status", equalTo(ORDER_OPEN_STATUS),
                        "courierId", equalTo(null),
                        "id", equalTo(4));
    }


    // создание нового заказа и проверка его статуса
    @Test
    public void createFirstOrderFullTest() {

        TestOrder requestOrder = new TestOrder(ORDER_OPEN_STATUS, "Konstantin", "111111", "correct request"); // заполняем данные полей заказа

        Gson gson = new Gson();
        String StringRequestOrder = gson.toJson(requestOrder); // превращаем джава-объект в json строку, сохраняем в переменную и передаем (сериализация)


        Response response = given(). // REST assured может возвращать объекты в виде класса response
                header("content-type", "application/json").body(StringRequestOrder).
                post(SwaggerTestUrl + "/test-orders").
                then().extract().response(); // извлекаем ответ в виде Json строки

        TestOrder responseOrder = gson.fromJson(response.body().asString(), TestOrder.class); // десериализуем ответ в обратно в java объект
        Assertions.assertEquals(responseOrder.getStatus(), ORDER_OPEN_STATUS, "error"); // проверяем статус созданного заказа
        System.out.println(responseOrder.toString());
    }


    // здесь для удобства логика теста вынесена в отдельный класс TestOrderFunction
    @Test
    public void createSecondOrderCompactTest() {
        TestOrder requestOrder2 = new TestOrder(ORDER_OPEN_STATUS, "Dmitriy", "2222222", "correct request2"); // передаем данные
        TestOrderFunction testOrderFunction = new TestOrderFunction(); // создаем объект класса TestOrderFunction, в котором хранится логика
        TestOrder responseOrder2 = testOrderFunction.postOrder(requestOrder2, 200); // проверяем код ответа
        Assertions.assertEquals(responseOrder2.getStatus(), ORDER_OPEN_STATUS, "Incorrect status"); // проверяем статус
        System.out.println(responseOrder2.toString()); // вывели на экран в читабельном виде

    }


    // авторизация пользователя (получение токена в случае успешной авторизации),
    // создание нового заказа, проверка его статус кода и статуса
    @Test
    public void checkLoginEndPointWithCorrectData() {

        Gson gson = new Gson();
        UserData userData = new UserData("user2", "hellouser2");

        String token = given(). // полученный ответ сохраняем в переменную token
                header("content-type", "application/json").
                body(gson.toJson(userData)).
                when().
                post(SwaggerTestUrl + "/login/student").
                then().
                // log().all(). // при необходимости включаем логирование
                        assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().response().asString();
        // Assertions.assertNotNull(token);  при необходимости проверяем, что пришел верный токен
        // System.out.println(token);

        TestOrder testOrder3 = new TestOrder(ORDER_OPEN_STATUS, "Sergey", "333333", "correct request3");
        Response response = given(). // создаем новый заказ
                header("content-type", "application/json").
                header("Authorization", "Bearer " + token). // для успешного создания заказа передаем полученный токен
                        body(gson.toJson(testOrder3)).
                when().
                post(SwaggerTestUrl + "/orders").
                then().assertThat().statusCode(200).
                extract().response();
        TestOrder responseOrder = gson.fromJson(response.body().asString(), TestOrder.class);
        Assertions.assertEquals(responseOrder.getStatus(), ORDER_OPEN_STATUS, "error"); // проверяем статус созданного заказа
        System.out.println(responseOrder.toString());

    }
}
















