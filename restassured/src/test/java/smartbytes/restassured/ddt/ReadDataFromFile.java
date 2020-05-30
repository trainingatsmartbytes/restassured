package smartbytes.restassured.ddt;

import java.util.List;

import smartbytes.restassured.utils.FileUtility;

public class ReadDataFromFile {

	public static void main(String[] args) {
    
	String filePath="/Users/sys/Documents/restassured/customers.csv";
	String separator=",";
	boolean ignoreFirstRow=true;
	
	List<List<String>> customerRecords = FileUtility.readFileData(filePath, separator, ignoreFirstRow);

	for (List<String> customerRecord : customerRecords) {
		System.out.println(customerRecord.get(0) +"\t" + customerRecord.get(1) +"\t" + customerRecord.get(8));
	}
	}
}
