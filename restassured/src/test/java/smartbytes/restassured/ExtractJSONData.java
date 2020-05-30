package smartbytes.restassured;

import static io.restassured.RestAssured.get;

import io.restassured.response.Response;

public class ExtractJSONData {
	public static void main(String[] args) {
		
	Response booksJson=	get("http://localhost:8080/api/test/books/json");
	System.out.println(booksJson.asString());
	//booksJson.prettyPrint();
	String author= booksJson.path("books[1].author");
	String country= booksJson.path("books[1].country");
	
	System.out.println(author);
	System.out.println(country);
	Integer totalBooks = booksJson.path("books.size()");
	System.out.println(totalBooks);
	
	for(int i=0;i<totalBooks;i++) {
		System.out.println(booksJson.path("books["+i+"].author"));
	}
	}

}
