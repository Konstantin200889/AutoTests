package org.example.api;
import com.google.gson.Gson;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import static io.restassured.RestAssured.given;



public class LoginFunction {

    private String baseUrl;
    private String login;
    private String password;


    public String loginAsStudent(String login, String password) {
        this.login = login;
        this.password = password;
        return null;
    }

    public LoginFunction()
    {
        try (InputStream input = new FileInputStream("src/main/resources/settings.properties"))
        {
            Properties prop = new Properties();
            prop.load(input);
            baseUrl = prop.getProperty("baseUrl"); // подгружаем нужные данные из properties
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void setLogin(String login) {
        this.login = login; // метод, который сохранит введенный логин в переменную login этого класса
    }

    public void setPassword(String password) {
        this.password = password; // метод, который сохранит введенный пароль в переменную password этого класса
    }

    public String postLoginFunction(LoginFunction body) // (LoginFunction body) - это всё содержимое класса Order1, кот. мы передаем
    {
        Gson gson = new Gson(); // вызываем в метод библиотеку Gson для сериализации/десериализации ответа
        String LoginAsStudent = gson.toJson(body); // сразу сохраняем ответ в переменную LoginAsStudent
        Response response = given(). // rest assured может возвращать ответы в виде спец.класса Response
                header("content-type", "application/json"). // передаем заголовки
                body(LoginAsStudent). // передаем тело запроса
                when().
                post(baseUrl + "/test-orders").
                then().statusCode(200).extract().response(); // извлекаем ответ

        return "Bearer" + response.body().asString();
    }
}


