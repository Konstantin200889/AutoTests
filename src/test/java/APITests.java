import com.google.gson.Gson;
import io.restassured.response.Response;
import org.DatabaseFunctions.DatabaseFunctions;
import org.apache.hc.core5.http.HttpStatus;
import org.example.dto.TestOrder;
import org.example.dto.TestOrder2;
import org.example.dto.UserData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class APITests {

// параметризированный тест (подгружаем данные из файла test.csv и проверяем заполнение полей при помощи Assertions)
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

   // проверка статуса определенного заказа
    @Test
    public void getFirstOrder()
    {
        when().
                get(SwaggerTestUrl + "/test-orders/{id}", 4).
                then().
                statusCode(200).
                body("status", equalTo("OPEN"),
                        "courierId", equalTo(null),
                        "id", equalTo(4));
    }


// создание нового заказа и проверка его статуса
    @Test
    public void postFirstOrder() {

        TestOrder requestOrder = new TestOrder(); // заполняем параметры полей класса Order
        requestOrder.setStatus("OPEN");
        requestOrder.setCustomerName("Konstantin");
        requestOrder.setCustomerPhone("2222222");
        requestOrder.setComment("correct request");

        Gson gson = new Gson();
        String StringRequestOrder = gson.toJson(requestOrder); // эта библиотека превращает джава-объект в json строку (сериализация)
        // передаем преобразованный в строку ответ

        Response response = given(). // REST assured может возвращать объекты в виде класса response
                header("content-type", "application/json").body(StringRequestOrder).
                post(SwaggerTestUrl + "/test-orders").
                then().extract().response();

        TestOrder responseOrder = gson.fromJson(response.body().asString(), TestOrder.class); // десериализуем ответ в формате json строки
        Assertions.assertEquals(responseOrder.getStatus(), "OPEN", "error"); // проверяем статус созданного заказа
        System.out.println(responseOrder.toString());
    }



    // 1) проверка успешной авторизации (получение токена авторизации),
    // 2) проверка успешного создания нового заказа (получение токена создания заказа)
    @Test
    public void checkLoginEndPointWithCorrectData() {

        Gson gson = new Gson();
        UserData userData = new UserData("user2", "hellouser2");

        String token = given().
                header("content-type", "application/json").
                body(gson.toJson(userData)).
                when().
                post(SwaggerTestUrl + "/login/student").
                then().
                // log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK).
                extract().response().asString();
        Assertions.assertNotNull(token);
        System.out.println(token);

        TestOrder2 testOrder2 = new TestOrder2("0", "Konstantin", "111111", "comment1", "OPEN");
        given().
                header("content-type", "application/json").
                header("Authorization", "Bearer "+ token).
                body(gson.toJson(testOrder2)).
                when().
                post(SwaggerTestUrl + "/orders").
                then().
                log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK);
        Assertions.assertNotNull(token);
        System.out.println(token);
    }


    // тестовый запрос к базе данных на выведение списка 100 пользователей
    @Test
    public void NewSelectUsers ()
    {
        DatabaseFunctions databaseFunctions = new DatabaseFunctions(); // создаем новый объект класса
        databaseFunctions.selectUsers(); // вызываем для него метод selectUsers,
        // который соединяется с базой и выводит список 100 пользователей (согласно установленному лимиту)
    }

}














