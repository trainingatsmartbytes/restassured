package smartbytes.restassured.authentication;

import static io.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import smartbytes.restassured.utils.SmartByteUtil;

public class BasicAuthTest {
   
	@BeforeClass
	public static void init() {
		System.out.println("entered init()");
		RestAssured.baseURI=SmartByteUtil.BASE_URI;
		System.out.println("exited init()");
	}

	@Test
	public void test_without_credentials() {
		System.out.println("entered test_without_credentials()");  
		get("/user/list").
		then().
		statusCode(401);
		System.out.println("exited test_without_credentials()");
	}
	@Test
	public void test_with_valid_credentials() {
		System.out.println("entered test_without_credentials()");
		given().
		auth().
		preemptive().
		basic("admin", "admin").
		get("/user/list").
		then().
		statusCode(200);
		System.out.println("exited test_without_credentials()");
	}
	@Test
	public void test_with_invalid_credentials() {
		System.out.println("entered test_with_invalid_credentials()");
		given().
		auth().
		preemptive().
		basic("admin", "admin1").
		get("/user/list").
		then().
		statusCode(401);
		System.out.println("exited test_with_invalid_credentials()");
	}

}

