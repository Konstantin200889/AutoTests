
package org.example.api;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.example.dto.TestOrder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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



    public TestOrder postOrder(TestOrder body, int headers)
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

