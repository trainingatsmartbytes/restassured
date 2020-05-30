package smartbytes.restassured.testng;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class CountryAPITest {

	@Test
	public void test_get_country_by_iso2code_IN() {
		given().
		pathParam("code", "IN").
		get("http://localhost:9090/api/country/get/iso2code/{code}").
		then(). 
		body("RestResponse.result.name",equalTo("India")). 
		body("RestResponse.result.alpha2_code",equalTo("IN")).
		body("RestResponse.result.alpha3_code",equalTo("IND"));
	}
	@Test
	public void test_get_country_by_iso2code_US() {
		given().
		pathParam("code", "US").
		get("http://localhost:9090/api/country/get/iso2code/{code}").
		then(). 
		body("RestResponse.result.name",equalTo("United States of America")). 
		body("RestResponse.result.alpha2_code",equalTo("US")).
		body("RestResponse.result.alpha3_code",equalTo("USA"));

	}
}
