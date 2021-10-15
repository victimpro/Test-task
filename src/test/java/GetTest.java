import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.specification.Argument;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.equalTo;

public class GetTest {
//        List<Map<String,Object>> users = get("/posts").as(new TypeRef<List<Map<String, Object>>>() {
//        @Override
//        public Type getType() {
//            return super.getType();

    @Test
    public void filterTest() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com/posts?id=1")
//                .basePath("/posts?id=1")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .log().body();
//                .body("userId", equalTo(1),"id", equalTo(1))
//                .body("userId", equalTo(1),"id", equalTo(2));
//
    }

    @Test
    public void getIdTest() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .basePath("/posts/1")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .body("id", equalTo(1)
                        , "userId", equalTo(1)
                        , "title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")
                        , "body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto")
                )
                .log().body().statusCode(200);

    }

//    @Test
//    public void getAllResourceTest() {
//        given()
//                .baseUri("https://jsonplaceholder.typicode.com")
//                .basePath("/posts")
//                .contentType(ContentType.JSON)
//                .when().get()
//                .then()
//                .body(users.toString(),equalTo())
//    }
//                .body();    }
}
