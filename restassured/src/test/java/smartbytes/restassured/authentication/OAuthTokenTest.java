package smartbytes.restassured.authentication;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class OAuthTokenTest {
	public static void main(String[] args) {
		Response response=	
				given().
				auth().
				oauth2("c39a39e1-fe24-40ff-9ce0-8681fc3e7164").
				log().all().
				get("http://localhost:9091/api/message").
				
				then().
				statusCode(200).extract().response();
				response.prettyPrint();
	}

}
