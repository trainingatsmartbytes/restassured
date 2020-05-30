package smartbytes.restassured.authentication;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import smartbytes.restassured.utils.SmartByteUtil;

public class TestEmployeeAPI {

final RequestSpecification reqSpec = new RequestSpecBuilder().build().
									auth().
									preemptive().
									basic("admin", "admin").log().body();

final ResponseSpecification respSpec = new ResponseSpecBuilder().
									  build().
									  statusCode(HttpStatus.SC_OK).
									  contentType(ContentType.XML);

	@BeforeClass
	public static void init() {
		System.out.println("entered init()");
		RestAssured.baseURI=SmartByteUtil.BASE_URI;
		System.out.println("exited init()");
	}

	@Test
	public void read_employees() {
		System.out.println("entered test_without_credentials()");
		given().
		spec(reqSpec).
		get("/employee/list").
		then().
		spec(respSpec);
		System.out.println("exited test_without_credentials()");
	}
	@Test
	public void show_employee_by_id() {
		System.out.println("entered test_without_credentials()");
		given().
		spec(reqSpec).
		get("/employee/show/1").
		then().
		spec(respSpec);
		System.out.println("exited test_without_credentials()");
	}
}

