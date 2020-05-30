package smartbytes.restassured.testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculatorTest {

  Calculator calculator = new Calculator();
  
  @Test
  public void addTest() {
   int result =  calculator.add(10, 5);
   assertEquals(result, 15);
  }

  @Test
  public void multiplyTest() {
	   int result =  calculator.multiply(10, 5);
	   assertEquals(result, 50);
  }

  @Test
  public void subtractTest() {
	   int result =  calculator.subtract(10, 5);
	   assertEquals(result, 5);
  }
}
