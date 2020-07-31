package ibm.gse.eda.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class OrderResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/orders")
          .then()
             .statusCode(200)
             .body(is("hello from reactive route"));
    }

}