package com.bremboparts.taf.api.test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BremboPartsApiTest {
    @DisplayName("Test API status code home page")
    @Test
    public void testStatusCodeHomePage() {
        RestAssured.baseURI = "https://www.bremboparts.com/europe/en";
        Response response = given().get(baseURI);
        Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
    }

    @DisplayName("Test API response contains search results ")
    @Test
    public void testResponseSearchResult(){
        RestAssured.baseURI = "https://www.bremboparts.com/europe/en/support/search";

        Response response = RestAssured.given()
                .param("searchtext", "Homologation certificates for Brembo")
                .get();
        String responseBody = response.getBody().asString();
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
        Assertions.assertTrue(responseBody.contains("Homologation certificates for Brembo"), "Element with text not found");
    }
}
