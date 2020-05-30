package smartbytes.restassured.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class SmartByteUtil {
	
	public static final String BASE_URI="http://localhost:9090/api";
	public static final RequestSpecification reqSpec = new RequestSpecBuilder().build().
			auth().
			preemptive().
			basic("admin", "admin");

}
