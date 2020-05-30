package smartbytes.restassured;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import smartbytes.restassured.utils.SmartByteUtil;

public class ExtractHeaderAndCookieData {

	public static void main(String[] args) {
	RestAssured.baseURI=SmartByteUtil.BASE_URI;
		
	Response customerReponse=
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body("{\n" + 
				"        \"firstName\": \"Kaushik\",\n" + 
				"        \"lastName\": \"Kumar\",\n" + 
				"        \"city\": \"Southfield\",\n" + 
				"        \"county\": \"Oakland\",\n" + 
				"        \"state\": \"MI\",\n" + 
				"        \"zip\": \"48075\",\n" + 
				"        \"phone1\": \"123-456-789\",\n" + 
				"        \"phone2\": \"123-456-789\",\n" + 
				"        \"email\": \"DeonnaKippley@smartbytes.com\",\n" + 
				"        \"web\": \"http://v-logics.com\"\n" + 
				"    }")
		.post("/customer/add")
		.then()
		.statusCode(HttpStatus.SC_CREATED)
		.extract()
		.response();
  String createdBy     =  customerReponse.getHeader("Created_By");
  String newCustomerId =  customerReponse.getCookie("new_customer_id");
  
  System.out.println("Created By :" + createdBy);
  System.out.println("Customre Id:" + newCustomerId);
  System.out.println(customerReponse.getHeader("Content-Type"));
  
	   

	}
}
