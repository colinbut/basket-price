/**
 * 
 */
package com.mycompany.basket_price.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.basket_price.model.goods.Apples;
import com.mycompany.basket_price.model.goods.Bread;
import com.mycompany.basket_price.model.goods.Milk;
import com.mycompany.basket_price.model.goods.Soup;

/**
 * SpecialOfferBuy2Get1HalfPriceTest class
 * 
 * @author colin
 *
 */
public class SpecialOfferBuy2Get1HalfPriceTest {

	private SpecialOfferBuy2Get1HalfPrice specialOffer;
	
	@Before
	public void setUp(){
		specialOffer = new SpecialOfferBuy2Get1HalfPrice(new Bread(), new Soup());
	}
	
	/**
	 * Test handling of special offer
	 */
	@Test
	public void testHandleSpecialOffer(){
		
		Bread bread = new Bread();
		Soup soup = new Soup();
		
		PriceBasket basket = new PriceBasket();
		basket.putItemInBasket(new Bread());
		basket.putItemInBasket(new Apples());
		basket.putItemInBasket(bread);
		basket.putItemInBasket(soup);
		basket.putItemInBasket(new Milk());
		
		Map<SpecialOffer, BigDecimal> specialOffersApplied = new HashMap<SpecialOffer, BigDecimal>();
		
		specialOffersApplied = specialOffer.handleSpecialOffer(specialOffersApplied, basket, bread);
		
		assertEquals(new BigDecimal(0.80), specialOffersApplied.get(specialOffer));
		
		
	}
}
