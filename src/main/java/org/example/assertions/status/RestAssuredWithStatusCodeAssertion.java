package org.example.assertions.status;

import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;

public class RestAssuredWithStatusCodeAssertion {
    public static void main(String[] args) {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/posts?userId=1")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .header("referer", "https://jsonplaceholder.typicode.com")
        .when()
                .get()
        .then()

                .assertThat()

                // Direct value in the status assertion
                .statusCode(200)

                // Could assert possible status codes as a flexibility.
                .statusCode(Matchers.anyOf(Matchers.is(200), Matchers.is(201)));

        System.out.println("TEST PASSED!");
    }
}



