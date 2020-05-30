package smartbytes.restassured;

import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.from;

import java.util.List;

import io.restassured.response.Response;

public class ExtractComplexJSON {
	public static void main(String[] args) {

		Response medications = get("http://localhost:8080/api/test/medications/json");
		// medications.prettyPrint();
		System.out.println(medications.path("medications[0].aceInhibitors[0].name"));

		List<String> labNames = from(medications.asString()).get("labs.name");

		for (String labName : labNames) {
			System.out.println(labName);
		}
		List<String> locations = from(medications.asString()).get("labs.location");

		System.out.println("locations...");
		for (String location : locations) {
			System.out.println(location);
		}
		
		//read all the labs with location 'Primary Care Clinic'
		List<String> labsFromPrimaryCareClinic = 
				from(medications.asString()).
				get("labs.findAll { it.location == 'Primary Care Clinic' }.name ");
				//get("labs.findAll { it.time == '3 Weeks' }.name ");

		System.out.println("locations...");
		for (String labName : labsFromPrimaryCareClinic) {
			System.out.println(labName);
		}
	}

}
