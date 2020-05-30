package smartbytes.restassured.authentication;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestAuthToken {
	private static String auth_token="";
	
	@BeforeClass
	public static void generate_token() {
	 auth_token=		
				given().
				auth().
				preemptive().
				basic("smartbytes", "secret").
				formParam("token_name", "access_token").
				formParam("grant_type", "password").
				formParam("username", "admin").
				formParam("password", "admin").
				formParam("scope", "read").
				post("http://localhost:9090/api/oauth/token").
				then().
				statusCode(200).extract().response().path("access_token");
	}
	
	@Test
	public void test1() {

		given().
		auth().
		oauth2(auth_token).
				get("http://localhost:9090/api/message").
		then().
		statusCode(200);
	}
	@Test
	public void test2() {

		given().
		auth().
		oauth2(auth_token).
		get("http://localhost:9090/api/message").
		then().
		statusCode(200);
		
	}
	@Test
	public void test3() {

				given().
				auth().
				oauth2(auth_token).
				get("http://localhost:9090/api/message").
				then().
				statusCode(200);
		
	}
}
