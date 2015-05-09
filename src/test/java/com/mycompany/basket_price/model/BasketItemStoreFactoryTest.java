/**
 * 
 */
package com.mycompany.basket_price.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.basket_price.exception.UnknownItemException;
import com.mycompany.basket_price.model.goods.Apples;
import com.mycompany.basket_price.model.goods.Bread;
import com.mycompany.basket_price.model.goods.Milk;
import com.mycompany.basket_price.model.goods.Soup;

/**
 * @author colin
 *
 */
public class BasketItemStoreFactoryTest {

	private BasketItemStoreFactory storeFactory;
	
	@Before
	public void setUp() {
		storeFactory = new BasketItemStoreFactory();
	}


	/**
	 * Test succeeding in getting the basket item(s)
	 * 
	 * Positive test
	 */
	@Test
	public void testSuccess_GetBasketItems() {
		
		assertTrue(storeFactory.getBasketItem("Apples") instanceof Apples);
		assertTrue(storeFactory.getBasketItem("Milk") instanceof Milk);
		assertTrue(storeFactory.getBasketItem("Soup") instanceof Soup);
		assertTrue(storeFactory.getBasketItem("Bread") instanceof Bread);
	}
	
	/**
	 * Test failure to get the basket item.
	 * 
	 * Negative test - the item supplied does not exist
	 * 
	 */
	@Test(expected=UnknownItemException.class)
	public void testFail_GetBasketItems() {
		storeFactory.getBasketItem("Chocolate");
	}

}
