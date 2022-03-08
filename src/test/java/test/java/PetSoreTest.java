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


public class PetSoreTest {
    String url = "https://locallhost:8080/cource/get/all";

    @Test
    public void CreatePetTest(){
        RequestSpecification request = buildRequest() ;
        Response response =
                executeGetRequest(request, url);
                        response.then()
                        .log().all()
                        .statusCode(200)
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/AddNewPet.json"));
    }


}
