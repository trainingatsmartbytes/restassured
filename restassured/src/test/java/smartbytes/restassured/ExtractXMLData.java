package smartbytes.restassured;

import static io.restassured.RestAssured.get;

import io.restassured.response.Response;

public class ExtractXMLData {
	public static void main(String[] args) {
		
	Response catalog=	get("http://localhost:8080/api/test/books/xml");
	//catalog.prettyPrint();
	System.out.println(catalog.path("catalog.book[0].@id"));
	System.out.println(catalog.path("catalog.book[0].author"));
	System.out.println(catalog.path("catalog.book[0].title"));
	System.out.println(catalog.path("catalog.book.size()"));
	}

}
