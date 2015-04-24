/**
 * 
 */
package com.mycompany.basket_price;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author colin
 *
 */
public class PriceBasketApplicationTest {

	PriceBasketApplication priceBasketApplication;
	
	@Before
	public void setUp(){
		priceBasketApplication = new PriceBasketApplication();
	}
	
	/**
	 * 
	 */
	@Test
	public void testPriceBasketApplication(){
		
		String[] testData = {"PriceBasket", "Apples", "Milk", "Bread", "Soup", "Soup"};
		
		String expectedOutput = "Subtotal: £4.40\n" +
								"Buy 2 Soup get Bread half price: -0.40p\n" + 
								"Apples 10.0% off: -0.10p\n" +
								"Total: £3.90";
		
		
		String actualOutput = priceBasketApplication.process(testData);
		System.out.println(actualOutput);
		assertEquals(expectedOutput, actualOutput);
		
		
	}
}
