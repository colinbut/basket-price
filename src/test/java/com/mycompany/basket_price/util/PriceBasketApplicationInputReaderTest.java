/**
 * 
 */
package com.mycompany.basket_price.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mycompany.basket_price.model.PriceBasket;
import com.mycompany.basket_price.model.goods.Apples;
import com.mycompany.basket_price.model.goods.Bread;
import com.mycompany.basket_price.model.goods.Milk;
import com.mycompany.basket_price.util.PriceBasketApplicationInputReader;

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
