package Page.roleServices;

import BaseUrl.BaseURL;
import PojoDatas.Roles;

import PojoDatas.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONArray;


import org.testng.Assert;
import org.testng.annotations.Test;
import resources.Token;
import utilities.JsonToJava;

import java.io.File;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class GetRol extends BaseURL {
    @Test
    public void getRolAppId() throws JsonProcessingException {


        //application/{appId}/role             ==>       appId=2
        specification.pathParams("applicationPath", "application", "appIdPath", 2, "rolePath", "role");
        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                get("/{applicationPath}/{appIdPath}/{rolePath}");
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        User rol = new User();
        Map<String, Object> actualDataMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);
        Map<String, Object> expectedlDataMap = JsonToJava.convertJsonToJavaObject((File) rol.getMyArrayList(), HashMap.class);

        for (String key : expectedlDataMap.keySet()) {
            Assert.assertEquals(expectedlDataMap.get(key), actualDataMap.get(key));
   /*     int userId;
        List<Integer> ids = User.getAllUsers().jsonPath().getList("id");
        int size = ids.size();
        userId = ids.get(size - 1);

        User.DeleteOrAddRoleBody requestBody;
        while (true) {
            requestBody = new User.DeleteOrAddRoleBody(userId);
            System.out.println(requestBody);
            if (!User.getUserById(userId).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id())) {
                Response response1 = User.addRoleToUser(requestBody);
                response.then().statusCode(200);
                break;
            }
        }
        assertTrue(User.getUserById(userId).jsonPath().getList("roles.role_id").contains(requestBody.getRole_id()));
        Response response2 = User.deleteRoleFromUser(requestBody);
        response.prettyPrint();
        response.then().statusCode(200);



        String jsonString = "[{\"id\":17,\"name\":\"A3M_ADMIN\",\"app_id\":2},"
                + "{\"id\":23,\"name\":\"Accountant\",\"app_id\":2},"
                + "{\"id\":4,\"name\":\"APP_DOMAIN_MANAGER\",\"app_id\":2},"
                + "{\"id\":30,\"name\":\"Customer\",\"app_id\":2},"
                + "{\"id\":6,\"name\":\"Guest\",\"app_id\":2},"
                + "{\"id\":26,\"name\":\"Logistics Manager\",\"app_id\":2},"
                + "{\"id\":27,\"name\":\"Logistics Personnel\",\"app_id\":2},"
                + "{\"id\":21,\"name\":\"Purchase Manager\",\"app_id\":2},"
                + "{\"id\":22,\"name\":\"Purchase Personnel\",\"app_id\":2},"
                + "{\"id\":29,\"name\":\"Quality Controller\",\"app_id\":2},"
                + "{\"id\":28,\"name\":\"Quality Manager\",\"app_id\":2},"
                + "{\"id\":19,\"name\":\"Sales Manager\",\"app_id\":2},"
                + "{\"id\":20,\"name\":\"Sales Personnel\",\"app_id\":2},"
                + "{\"id\":18,\"name\":\"Store Manager\",\"app_id\":2},"
                + "{\"id\":24,\"name\":\"Warehouse Manager\",\"app_id\":2},"
                + "{\"id\":25,\"name\":\"Warehouse Personnel\",\"app_id\":2},"
                + "{\"id\":5,\"name\":\"Business Owner\",\"app_id\":2}]";


        ;
      //  List<Object> expectedList = Arrays.asList(jsonString.split("\n"));

     //   StringBuilder response1 = new StringBuilder(response.toString());
      //  String jsonResponse = response1.toString();
      //  JSONArray jsonArray = new JSONArray(jsonResponse);
      //  System.out.println("jsonArray = " + jsonArray);

        //    List<JSONObject> actualList = new ArrayList<>();
      //  for (int i = 0; i < jsonArray.length(); i++) {
        //    JSONObject jsonObject = jsonArray.getJSONObject(i);
          //  actualList.add(jsonObject);
        //}

        //assertEquals(expectedList.size(), actualList.size());
       // System.out.println("expectedList = " + expectedList);
     //   System.out.println("actualList = " + actualList);

      /*  boolean isListsEqual = true;
        for (int i = 0; i < expectedList.size(); i++) {
            if (!actualList.contains(expectedList.get(i))) {
                isListsEqual = false;
                break;
            }
        }
*/
        }

      /*  JSONArray jsonArray = new JSONArray(jsonString);
        List<Map<String, Object>> expectetData = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, Object> dataMap = new HashMap<>();

            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = jsonObject.get(key);
                dataMap.put(key, value);
            }
            expectetData.add(dataMap);*/

        // Map<String,Object> actualDataMap=response.as(HashMap.class);
        // System.out.println("Actual Data: " + actualDataMap);


        //  System.out.println("actualData = " + actualData);*/
        // Map<String,Object> actualDataMap=response.as(HashMap.class);
        //System.out.println("Actual Data: " + actualDataMap);
        //response.prettyPrint();*/

    }








    @Test
    public void negatifGetRolAppId() {

        //                       PathParam    ==> appId=3

        specification.pathParams("applicationPath", "application", "appIdPath", 3, "rolePath", "role");
        Response response1 = given().spec(specification).
                contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                get("/{applicationPath}/{appIdPath}/{rolePath}");

        response1.prettyPrint();
        response1.then().assertThat().statusCode(404);



    }
    @Test
    public void id23() {
        //                       PathParam    ==> /role/id    JsonPath cevirerek  dogrulama

        specification.pathParams("rolePath", "role","idPath",23);
        Response response2 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response2.then().assertThat().statusCode(200).body("id",equalTo(23));
        response2.then().assertThat().contentType(ContentType.JSON);
       // response2.prettyPrint();
        JsonPath jsonPath = response2.jsonPath();
        assertEquals(23,jsonPath.getInt("id"));
        assertEquals("Accountant",jsonPath.getString("name"));
        assertEquals(2,jsonPath.getString("app_id"));





    }
    @Test
    public void id27() {
        //                       PathParam    ==> /role/id     Matchers ile dogrulama

        specification.pathParams("rolePath", "role","idPath",27);
        Response response3 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");
        //response3.prettyPrint();
        response3.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("id", Matchers.equalTo(27),
                        "name", Matchers.equalTo("Logistics Personnel"),
                        "app_id", Matchers.equalTo(2));

    }

    @Test
    public void id30() {

        //                       PathParam    ==> /role/id            Matchers ile dogrulama

        specification.pathParams("rolePath", "role","idPath",30);
        Response response4 = given().spec(specification).
                when().
                header("Authorization", Token.BO_token()).
                get("/{rolePath}/{idPath}");

        response4.
                then().
                assertThat().
                statusCode(200).
                body("id", Matchers.equalTo(30),
                        "name", Matchers.equalTo("Customer"),
                        "app_id", Matchers.equalTo(2));


    }
    @Test
    public void negatifId10() {

        //   PathParam    ==> /role/id

        Response response5= null;

        specification.pathParams("rolePath", "role","idPath",10);
     try {
         response5 = given().spec(specification).
                 when().
                 header("Authorization", Token.BO_token()).
                 get("/{rolePath}/{idPath}");

     }catch (Exception e) {
         Assert.assertTrue(e.getMessage().contains("Not Found"));

     }


    }

}
