import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class TestDogCeoApi {
    /**
     * <p>Esta função serve para podermos setar os elementos base das resquisições.
     * <a href="https://javadoc.io/static/io.rest-assured/rest-assured/4.2.0/io/restassured/specification/RequestSpecification.html">RequestsSpecification</a>
     * </p>
     * @return RequestSpecification com elementos base setados para reutilização.
     */
    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder().setBaseUri("https://dog.ceo/api")
                .build();
    }

    /**
     * <p>Teste de sucesso do path /breeds/list/all
     * <a href="https://dog.ceo/dog-api/documentation/">Api Doc</a>
     * </p>
     */
    @Test
    public void testDogApiListAll() {

        Response response = given().spec(requestSpecification())
                .when().get("/breeds/list/all")
                .then().assertThat().statusCode(200)
                    .header("Content-Type", "application/json")
                    .body("status", equalTo("success"))
                    .time(lessThan(5000L))
                    .log().ifError()
                    .extract().response();
    }

    /**
     * <p>Teste de sucesso do path /breeds/{breed}>/images
     * <a href="https://dog.ceo/dog-api/documentation/">Api Doc</a>
     * </p>
     */
    @Test
    public void testDogApiByBreedImagesStatusSucces(){
        Response response = given().spec(requestSpecification())
                .when().get("/breed/australian/images")
                .then().assertThat().statusCode(200)
                .header("Content-Type", "application/json")
                .body("status", equalTo("success"))
                .time(lessThan(5000L))
                .extract().response();
    }

    /**
     * <p>Teste de falha do path /breeds/{breed}/images
     * <a href="https://dog.ceo/dog-api/documentation/">Api Doc</a>
     * </p>
     */
    @Test
    public void testDogApiByBreedHoundImagesStatusError(){
        Response response = given().spec(requestSpecification())
                .when().get("/breed/gato/images")
                .then().assertThat().statusCode(404)
                .header("Content-Type", "application/json")
                .body("status", equalTo("error"))
                .time(lessThan(5000L))
                .extract().response();
    }

    /**
     * <p>Teste de sucesso do path /breeds/image/random
     * <a href="https://dog.ceo/dog-api/documentation/">Api Doc</a>
     * </p>
     */
    @Test
    public void testDogApiImageRandom(){
        Response response = given().spec(requestSpecification())
                .when().get("/breeds/image/random")
                .then().assertThat().statusCode(200)
                .header("Content-Type", "application/json")
                .body("status", equalTo("success"))
                .time(lessThan(5000L))
                .extract().response();
    }
}