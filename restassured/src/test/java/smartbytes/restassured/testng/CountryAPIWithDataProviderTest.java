package smartbytes.restassured.testng;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CountryAPIWithDataProviderTest {

	@Test(dataProvider="country-data")
	public void test_get_country_by_iso2code(String[] data) {
		System.out.println("Calling iso2code method with country code :" + data[0]);
		given().
		pathParam("code", data[0]).
		get("http://localhost:9090/api/country/get/iso2code/{code}").
		then(). 
		body("RestResponse.result.name",equalTo(data[1])). 
		body("RestResponse.result.alpha2_code",equalTo(data[2])).
		body("RestResponse.result.alpha3_code",equalTo(data[3]));
	}
	
	@DataProvider(name="country-data")
	public Object[][] countryData(){
		return new Object[][] {
								{"IN","India","IN","IND"},
								{"US","United States of America","US","USA"}
							  };
		

	}
	
}
