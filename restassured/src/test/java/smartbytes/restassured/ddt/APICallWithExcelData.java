package smartbytes.restassured.ddt;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.http.ContentType;
import smartbytes.restassured.utils.ExcelUtility;

public class APICallWithExcelData {

	public static void main(String[] args) {
		String excelFilePath="/Users/sys/Documents/restassured/SmartBytes_API_TestData.xlsx";
		String sheetName="Products";
		
		List<List<String>> productRecords = ExcelUtility.readExcelData(excelFilePath, sheetName);	
		
		String productId="";
		String productName="";
		double productPrice=0;
		
		for(List<String> productRecord : productRecords) {
			productId= productRecord.get(0);
			productName=productRecord.get(1);
			productPrice = Double.parseDouble(productRecord.get(2));
			String requestBody="{" + 
					"\"description\": \""+productName+"\"," + 
					"\"price\": "+productPrice+"," + 
					"\"productId\": \""+productId+"\"" + 
					"}";
			given().
			contentType(ContentType.JSON).
			body(requestBody).
			post("http://localhost:9090/api/product").
			then().
				extract().
				response().
				prettyPrint();
		}
	}
}
