package PermissionServices;

import BaseUrl.BaseURL;
import PojoDatas.Permission;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import resources.Token;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostPermissions extends BaseURL {
    @Test
    public void post() {
        specification.pathParam("permissionPath", "permission");

        //Permission reqBody=new Permission("Karete","Kusak",2);
       String reqBody= "{\n" +
               "               \"resource\": \"CREATE\",\n" +
               "                \"action\": \"WORK, WRİTE.\",\n" +
               "                \"app_id\": 2\n" +
               "        }";
        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                body(reqBody).
                post("/{permissionPath}");

        response.then().assertThat().statusCode(201).
                contentType(ContentType.JSON);
        response.prettyPrint();
        Permission actualDataMap=response.as( Permission.class);

        System.out.println("actualDataMap = " + actualDataMap);

        assertEquals(2,actualDataMap.getApp_id());
        assertEquals("WORK, WRİTE.",actualDataMap.getAction());
        assertEquals("CREATE",actualDataMap.getResource());



    }
}
