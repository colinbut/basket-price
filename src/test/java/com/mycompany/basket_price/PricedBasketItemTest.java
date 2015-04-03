/**
 * 
 */
package com.mycompany.basket_price;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author colin
 *
 */
public class PricedBasketItemTest {

	private PricedBasketItem basketItem;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		basketItem = new PricedBasketItem("Apples", new BigDecimal(1.00));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		basketItem = null;
	}

	@Test
	public void testBasketItem() {
		
		assertEquals("Apples", basketItem.getItemName());
		assertEquals(1.00, basketItem.getPrice().doubleValue(), 0.00);
		
	}

}
