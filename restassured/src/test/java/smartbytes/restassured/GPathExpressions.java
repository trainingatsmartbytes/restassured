package smartbytes.restassured;

import static io.restassured.path.json.JsonPath.*;

import java.io.File;
import java.util.List;

public class GPathExpressions {
	public static void main(String[] args) {
		File productFile = new File("./resources/local_products.json");
		Object productData = from(productFile).get("ProductCollection[0]");
		System.out.println(productData);

		// filter products by currency 'EUR'
		List<Object> productsWithCurrency_EUR = from(productFile)
				.get("ProductCollection.findAll { it.CurrencyCode =='EUR'}");
		System.out.println(productsWithCurrency_EUR.size());

		// filter products by price 900-1000 && Status='Available'
		List<Object> productsWithCurrency_ByPriceRange = from(productFile).get(
				"ProductCollection.findAll { (it.Price >=900 && it.price <=1000) && it.Status=='Available' && it.CurrencyCode =='USD' }.Name");
		System.out.println(productsWithCurrency_ByPriceRange.size());
		for (Object product : productsWithCurrency_ByPriceRange) {
			System.out.println(product);
		}
		System.out.println("DDR3 Products...");
		// filter products by price 900-1000 && Status='Available'
				List<Object> productsWithDDR3 = from(productFile).get(
						"ProductCollection.findAll {it.Description =~ /1000 GB Hard Disc/ }");
				System.out.println(productsWithDDR3.size());
				for (Object product : productsWithDDR3) {
					System.out.println(product);
				}
	}
}
