package PermissionServices;

import BaseUrl.BaseURL;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;
import resources.Token;

import static io.restassured.RestAssured.given;



public class DeletePermission extends BaseURL {
    @Test
    public void delete() {
        ///auth/api/permission/{id}
        specification.pathParams("permissionPath", "permission", "idPath",647);
        //Permission reqBody = new Permission(PostPermissions.id, "TEAM45", "WORK, WRİTE.", 2);

        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                delete("/{permissionPath}/{idPath}");

        response.then().assertThat().statusCode(200);
        //PostPermissions.id
    }
}