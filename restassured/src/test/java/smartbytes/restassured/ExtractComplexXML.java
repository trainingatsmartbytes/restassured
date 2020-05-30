package smartbytes.restassured;

import static io.restassured.RestAssured.get;
import static io.restassured.path.xml.XmlPath.with;

import java.util.List;

import io.restassured.internal.path.xml.NodeImpl;
import io.restassured.response.Response;

public class ExtractComplexXML {
	public static void main(String[] args) {

		Response customers = get("http://localhost:8080/api/customer/list/xml");
		//customers.prettyPrint();
		
		Integer totalCustomers = with(customers.asString()).get("ArrayList.item.size()");
		System.out.println("totalCustomers = "+totalCustomers);
		
		//find all customers from state LA
		
		List<NodeImpl> customersList_LA= with(customers.asString()).
		get("ArrayList.item.findAll{ it.state =='LA'}");
		
		System.out.println("customes from LA :" +customersList_LA.size() );
		for(NodeImpl customer : customersList_LA) {
			System.out.println(customer.get("firstName") +" - "+ customer.get("lastName"));
		}
		
		List<String> firstNamesFromLA= with(customers.asString()).
				getList("ArrayList.item.findAll { it.lastName =~ /me/}.lastName");
				
				System.out.println("-------");
				for(String firstName : firstNamesFromLA) {
					System.out.println(firstName);
				}
		
	}
	
}
