package smartbytes.restassured.authentication;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class GenerateOAuthToken {

public static void main(String[] args) {
	
String auth_token=		
		given().
		auth().
		preemptive().
		basic("smartbytes", "secret").
		formParam("token_name", "access_token").
		formParam("grant_type", "password").
		formParam("username", "admin").
		formParam("password", "admin").
		formParam("scope", "read").
		log().all().
		post("http://localhost:9091/api/oauth/token").
		then().
		statusCode(200).extract().response().path("access_token");
		
		System.out.println("OAuth Token = " + auth_token);
		
		Response response=	
				given().
				auth().
				oauth2(auth_token).
				get("http://localhost:9091/api/message").
				then().
				statusCode(200).extract().response();
				response.prettyPrint();
	}
}
