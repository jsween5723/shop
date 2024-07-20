package org.example.shop.api.consumer;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import org.hamcrest.text.MatchesPattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerControllerTest {

    private final ObjectMapper objectMapper;

    public ConsumerControllerTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    @DisplayName("고객 추가")
    public void create() {
        CreateConsumerRequest request = new CreateConsumerRequest("조현창", "01022222222", "대한민국");
        given().body(request).accept(ContentType.ANY).when().post("/api/consumers").then()
            .statusCode(201);

        when().get("/api/consumers").then().statusCode(200).contentType(ContentType.JSON)
            .body("$[0]", equals(new FindConsumerResponse(1, "조현창", "01022222222", "대한민국")));

        get("/api/consumers").body("$[0]", equals(request));
    }
}