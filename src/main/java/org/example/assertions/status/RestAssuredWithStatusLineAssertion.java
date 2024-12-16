package org.example.assertions.status;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredWithStatusLineAssertion {
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

                // Direct value in the status line assertion
                .statusLine("HTTP/1.1 200 OK")

                // Could assert possible status lines as a flexibility.
                .statusLine(anyOf(is("HTTP/1.1 200 OK"), is("HTTP/1.1 201 CREATED")))

                // Let us say you know the status partially
                .statusLine(containsString("200 OK"));

        System.out.println("TEST PASSED!");
    }
}



