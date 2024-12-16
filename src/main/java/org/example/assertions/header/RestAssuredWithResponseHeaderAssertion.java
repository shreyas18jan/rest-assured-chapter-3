package org.example.assertions.header;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredWithResponseHeaderAssertion {
    public static void main(String[] args) {

        HashMap<String, String> expectedHeaders = new HashMap<>();
        expectedHeaders.put("Content-Type", "application/json; charset=utf-8");

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

                // Direct value in the header key value assertion
                .header("Content-Type", "application/json; charset=utf-8")

                // Could assert possible header key value as a flexibility.
                .header("Content-Type", anyOf(is("application/json; charset=utf-8"), is("application/text; charset=utf-8")))

                // Let us say you know the header key value partially
                .header("Content-Type", containsString("application/json"))

                // Assert multiple headers at the same time
                .headers(expectedHeaders);

        System.out.println("TEST PASSED!");
    }
}



