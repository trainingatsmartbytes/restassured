package smartbytes.restassured;

import static io.restassured.RestAssured.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import smartbytes.restassured.utils.SmartByteUtil;

public class TestCustomerAPI2 {

	public static void main(String[] args) {
RestAssured.baseURI=SmartByteUtil.BASE_URI;
		
		Response catalog = get("http://localhost:8080/api/test/complex_xml");
		catalog.prettyPrint();
		System.out.println("id:"+ catalog.path("catalog.book[0].@id"));
		System.out.println("author:"+ catalog.path("catalog.book[0].author"));
		
		Integer noOfBooks = catalog.path("catalog.book.size()");
		System.out.println("Total Books: " + noOfBooks);
		for(int i=0;i<noOfBooks;i++) {
			System.out.println(catalog.path("catalog.book["+i+"].@id"));
		}
	}

}
