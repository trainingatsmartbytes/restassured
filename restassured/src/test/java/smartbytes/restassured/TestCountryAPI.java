package smartbytes.restassured;

import static io.restassured.RestAssured.*;


public class TestCountryAPI {

	
	public static void main(String[] args) {
		
		//call the REST URI http://localhost:8080/api/country/get/iso2code/IN
		
		get("http://localhost:8080/api/country/get/iso2code/US").
		then().
			extract().
			response().
			prettyPrint();
		
		get("http://localhost:8080/api/country/get/iso3code/IND").
		then().
			extract().
			response().
			prettyPrint();
	}

}
