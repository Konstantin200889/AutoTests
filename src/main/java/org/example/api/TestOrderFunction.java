
package org.example.api;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.dto.TestOrder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class TestOrderFunction
{
    private String baseUrl;

    public TestOrderFunction()
    {
        try (InputStream input = new FileInputStream("src/main/resources/settings.properties"))
        {
            Properties prop = new Properties();
            prop.load(input);
            baseUrl = prop.getProperty("baseUrl");
        }
        catch (IOException ex)

        {
            ex.printStackTrace();
        }
    }


    // map - специальная коллекция для хранения данных, которая хранит ключи, значения и даже классы(можно их передавать)

    public TestOrder postFirstOrder(TestOrder body, Map<String, String> headers)
    {
        Gson gson = new Gson();
        String StringRequestOrder = gson.toJson(body);

        Response response = given().
                header("content-type", "application/json").
                body(StringRequestOrder).
                when().
                post(baseUrl + "/test-orders").
                then().statusCode(200).extract().response();

        return gson.fromJson(response.body().asString(), TestOrder.class);
    }
}

