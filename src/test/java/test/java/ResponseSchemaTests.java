package test.java;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import lombok.val;
//import models.AddNewPet.AddNewPet;
//import models.AddNewPet.Category;
//import models.AddNewPet.TagsItem;
import org.junit.jupiter.api.Test;

import static helpers.Helpers.*;


public class ResponseSchemaTests {


    @Test
    public void GetAllCoursesSchemaTest(){
        String url = "http://localhost:8080/cource/get/all";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
                        response.then()
                        .log().all()
                        .statusCode(200)
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Courses.json"));
    }

    @Test
    public void GetAllUsersSchemaTest(){
        String url = "http://localhost:8080/user/get/all";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);


                        response.then()
                        .log().all()
                        .statusCode(200)
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Users.json"));
    }

    @Test
    public void GetUserByIdSchemaTest(){
        String url = "http://localhost:8080/user/get/123";
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);


        response.then()
                .log().all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/Score.json"));
    }



}
