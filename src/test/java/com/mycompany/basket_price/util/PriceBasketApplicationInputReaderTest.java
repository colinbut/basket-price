/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mycompany.basket_price.exception.UnknownItemException;
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

	/**
	 * Test the reading of input data from the command line
	 */
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
		assertTrue(expectedBasket.getBasketItems().size() == actualBasket.getBasketItems().size());

		
	}
	
	/**
	 * Test the failure to retrieve a basket because of an unknown item
	 */
	@Test(expected = UnknownItemException.class)
	public void testReadInputFromCommandLineThrowingUnknownItemException(){
		
		// Test Data
		String[] input = {"ShoppingBasket", "Ginger", "Milk", "Bread"};
			
		// this line should throw UnknownItemExceptionK
		PriceBasketApplicationInputReader.readInputFromCommandLine(input);
		
	}

}
