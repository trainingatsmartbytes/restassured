package smartbytes.restassured.ddt;

import java.util.ArrayList;
import java.util.List;

import smartbytes.restassured.utils.ExcelUtility;

public class WriteDataToExcel {

	public static void main(String[] args) {
		String excelFilePath="/Users/sys/Documents/restassured/test.xlsx";
		String sheetName="Test1";
		
		List<Object[]> records = new ArrayList<Object[]>();
		
		Object[] record1 = {"Tom","Cruise","New York","tom.cruise@gmail.com"};
		Object[] record2 = {"Tom","Hanks","New York","tom.hanks@gmail.com"};
		Object[] record3 = {"James","Bond","New York","james.bond@gmail.com"};
		Object[] record4 = {"John","Doe","New York","john.doe@gmail.com"};
		
		records.add(record1);
		records.add(record2);
		records.add(record3);
		records.add(record4);
		
		ExcelUtility.writeToExcel(excelFilePath, sheetName, records);
	}
}
