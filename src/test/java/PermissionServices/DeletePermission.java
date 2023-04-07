package PermissionServices;

import BaseUrl.BaseURL;
import PojoDatas.Permission;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import resources.Token;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class DeletePermission extends BaseURL {
    @Test
    public void put() {
        ///auth/api/permission/{id}
        specification.pathParams("permissionPath", "permission", "idPath", PostPermissions.id);
        //Permission reqBody = new Permission(PostPermissions.id, "TEAM45", "WORK, WRİTE.", 2);

        Response response = given().spec(specification).contentType(ContentType.JSON).
                when().
                header("Authorization", Token.BO_token()).
                delete("/{permissionPath}/{idPath}");

        response.then().assertThat().statusCode(200);

    }
}