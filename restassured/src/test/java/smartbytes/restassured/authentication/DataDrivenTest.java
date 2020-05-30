package smartbytes.restassured.authentication;

import static io.restassured.RestAssured.given;

import java.util.List;

import smartbytes.restassured.utils.ExcelUtility;
public class DataDrivenTest {

	public static void main(String[] args) {
		String excelFilePath="/Users/sys/Documents/restassured/SmartBytes_API_TestData.xlsx";
		String sheetName="CustomerAPI";
		
		List<List<String>> testCases = ExcelUtility.readExcelData(excelFilePath, sheetName);	
		
		String method="";
		String testCaseName="";
		String restURI="";
		String reqBody="";
		String reqContentType="";
		String respContentType="";
		int respStatusCode;
		
		for(List<String> testCase : testCases) {
			
			method = testCase.get(0);
			testCaseName= testCase.get(1);
		    restURI= testCase.get(2);
			reqContentType= testCase.get(3);
			reqBody =testCase.get(4);
			respStatusCode=(int)Double.parseDouble(testCase.get(5));
			respContentType= testCase.get(6);
			
		    System.out.println("-------------------------------------------------------------------");
			System.out.println("Request Method:" + method);
			System.out.println("Test Case:" + testCaseName);
			System.out.println("\tRequest URI:" + restURI);
			System.out.println("\tRequest Body:" + reqBody);
			System.out.println("\tRequest Content Type:" + reqContentType);
			System.out.println("\tResp Code :" + respStatusCode);
			System.out.println("\tResp Content Type:" + respContentType);
			System.out.println("-------------------------------------------------------------------");

			System.out.println("Test Case:" + testCaseName);
			if(method.equals("GET")) {
				//CALL THE REST API
				
				given().
					contentType(reqContentType).
				get(restURI).
				then().
					statusCode(respStatusCode);

			}else if(method.equals("POST")) {
				given().
					contentType(reqContentType).
					body(reqBody).
				post(restURI).
				then().
				statusCode(respStatusCode).extract().response().prettyPrint();
			}else if(method.equals("PUT")) {
				given().
					contentType(reqContentType).
					body(reqBody).
				put(restURI).
				then().extract().response().prettyPrint();
			}
		}
	}
}
