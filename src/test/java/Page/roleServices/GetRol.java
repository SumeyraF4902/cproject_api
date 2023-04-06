package Page.roleServices;

import BaseUrl.BaseURL;
import io.restassured.response.Response;
import org.junit.Test;
import resources.Token;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRol extends BaseURL {
    @Test
    public void getRolAppId() {


        //application/{appId}/role             ==>       appId=2
        specification.pathParams("applicationPath", "application", "appIdPath", 2, "rolePath", "role");
        Response response = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{applicationPath}/{appIdPath}/{rolePath}");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();

        HashMap<String, Object> actualData = response.as(HashMap.class);
        System.out.println("Actual Data: " + actualData);

    }

    @Test
    public void role() {

        //                       PathParam    ==> /role

        specification.pathParam("rolePath", "role");
        Response response1 = given().spec(specification).
                when().
                header("Authorization", Token.cstmr_token()).
                get("/{rolePath}");

        response1.then().assertThat().statusCode(200);
        response1.prettyPrint();
        HashMap<String, Object> actualData = response1.as(HashMap.class);
        System.out.println("Actual Data: " + actualData);


    }
    @Test
    public void id23() {
        //                       PathParam    ==> /role/id

        specification.pathParams("rolePath", "role","idPath",23);
        Response response2 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response2.then().assertThat().statusCode(200);
        response2.prettyPrint();


    }
    @Test
    public void id27() {
        //                       PathParam    ==> /role/id

        specification.pathParams("rolePath", "role","idPath",27);
        Response response3 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response3.then().assertThat().statusCode(200);
        response3.prettyPrint();


    }

    @Test
    public void id30() {

        //                       PathParam    ==> /role/id

        specification.pathParams("rolePath", "role","idPath",30);
        Response response1 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response1.then().assertThat().statusCode(200);
        response1.prettyPrint();


    }


}
