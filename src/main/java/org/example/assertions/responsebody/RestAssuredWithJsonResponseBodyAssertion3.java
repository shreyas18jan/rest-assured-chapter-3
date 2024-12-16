package org.example.assertions.responsebody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredWithJsonResponseBodyAssertion3 {
    public static void main(String[] args) {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/users/1/todos")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .header("referer", "https://jsonplaceholder.typicode.com")
        .when()
                .get()
        .then()
                .assertThat()

                // Access Json Array Length
                .body("[0].completed",
                        equalTo(false));
    }
}








