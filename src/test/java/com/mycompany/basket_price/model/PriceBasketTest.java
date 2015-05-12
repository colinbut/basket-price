/**
 * 
 */
package com.mycompany.basket_price.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mycompany.basket_price.model.goods.Apples;
import com.mycompany.basket_price.model.goods.Bread;

/**
 * @author colin
 *
 */
public class PriceBasketTest {

	PriceBasket priceBasket;

	@Before
	public void setUp(){
		priceBasket = new PriceBasket();
	}
	
	@Test
	public void testPutItemInBasket() {
		
		Apples apples = new Apples();
		priceBasket.putItemInBasket(apples);
		assertTrue(priceBasket.getBasketItems().containsKey(apples));
		
		priceBasket.putItemInBasket(new Apples());
		assertEquals(1, priceBasket.getBasketItems().size());
		
	}
	
	@Test
	public void testBasketContainItem(){
		
		priceBasket.getBasketItems().put(new Bread(), 3);
		assertTrue(priceBasket.basketContainItem(new Bread()));
		
	}

}