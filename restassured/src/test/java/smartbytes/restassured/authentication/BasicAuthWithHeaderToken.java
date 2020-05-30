package smartbytes.restassured.authentication;

import static io.restassured.RestAssured.*;

public class BasicAuthWithHeaderToken {

	public static void main(String[] args) {
		given().
		header("Authorization", "Basic c2FzaGk6c2FzaGk=").
		get("http://localhost:8080/api/user/list").
		then().
		statusCode(200);

	}
}
