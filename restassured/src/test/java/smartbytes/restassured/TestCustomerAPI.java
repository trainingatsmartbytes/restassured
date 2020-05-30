package smartbytes.restassured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.apache.http.HttpStatus;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import smartbytes.restassured.utils.SmartByteUtil;


public class TestCustomerAPI {

	
    @BeforeClass
    public static void init() {
    	System.out.println("initialized the base uri");
    	RestAssured.baseURI=SmartByteUtil.BASE_URI;
    }
    
    @AfterClass
    public static void teardown() {
    	System.out.println("completed execution of test cases");
    	
    }
	@Test
	public void test_search_customer_with_an_ID() {
	
		System.out.println("entering test_search_customer_with_an_ID()");
		
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.queryParam("id", "250")
		.get("/customer/show")
		.then()
		.statusCode(HttpStatus.SC_OK)
		.body("firstName", equalTo("Deonna") )
		.body("lastName", equalTo("Kippley"));
	
		System.out.println("exiting test_search_customer_with_an_ID()");
	}
	
	@Test
	public void test_create_customer() {
		System.out.println("entering test_create_customer");
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
		.body("id",greaterThanOrEqualTo(1));
		System.out.println("exiting test_create_customer");
	}
	@Test
	public void test_update_customer() {
		System.out.println("entering test_update_customer");
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("id", "2")
		.body(" {\n" + 
				"        \"firstName\": \"Josephine\",\n" + 
				"        \"lastName\": \"Darakjy\",\n" + 
				"        \"city\": \"Brighton\",\n" + 
				"        \"county\": \"Livingston\",\n" + 
				"        \"state\": \"MI\",\n" + 
				"        \"zip\": \"787878\",\n" + 
				"        \"phone1\": \"999-999-999\",\n" + 
				"        \"phone2\": \"777-777-777\",\n" + 
				"        \"email\": \"Josephine_Darakjy@smartbytes.com\",\n" + 
				"        \"web\": \"http://v-logics.com\"\n" + 
				"    }")
		.put("/customer/update/{id}")
		.then()
		.statusCode(HttpStatus.SC_OK);
		System.out.println("exiting test_update_customer");
	}
	
	@Ignore
	@Test
	public void test_delete_customer() {
		given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("id", "1")
		.delete("/customer/delete/{id}")
		.then()
		.statusCode(HttpStatus.SC_OK);
	}
	
}
