package org.example.assertions.responsebody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RestAssuredWithJsonResponseBodyAssertion2 {
    public static void main(String[] args) {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/users")
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .header("referer", "https://jsonplaceholder.typicode.com")
        .when()
                .get()
        .then()
                .assertThat()

                // Access Json Array Length
                .body("size()", equalTo(10))

                // Access specific index in the Json Array
                .body("[4].company.name",
                        is("Keebler LLC"))

                // Check each Json Object has a specific key or not!
                .body("", everyItem(hasKey("email")));

        System.out.println("TEST PASSED!");
    }
}



