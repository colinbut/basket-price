/**
 * 
 */
package com.mycompany.basket_price;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mycompany.basket_price.goods.Apples;
import com.mycompany.basket_price.goods.Bread;
import com.mycompany.basket_price.goods.Milk;

/**
 * @author colin
 *
 */
public class PriceBasketApplicationInputReaderTest {

	@Test
	public void testReadInputFromCommandLine() {
		
		// Test Data
		String[] input = {"ShoppingBasket", "Apples", "Milk", "Bread"};
		
		// Expectations
		PriceBasket expectedBasket = new PriceBasket();
		expectedBasket.putItemInBasket(new Apples());
		expectedBasket.putItemInBasket(new Milk());
		expectedBasket.putItemInBasket(new Bread());
		
		// Run
		PriceBasket actualBasket = 
				PriceBasketApplicationInputReader.readInputFromCommandLine(input);
		
		// Verify
		assertTrue(expectedBasket.getBasketItems().size() == 
				actualBasket.getBasketItems().size());

		
		
	}

}
