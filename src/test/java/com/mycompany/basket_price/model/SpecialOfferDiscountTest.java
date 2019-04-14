/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.basket_price.model.goods.Apples;

/**
 * SpecialOfferDiscountTest class
 * 
 * @author colin
 *
 */
public class SpecialOfferDiscountTest {

	private SpecialOfferDiscount specialOfferDiscount;
	
	@Before
	public void setUp(){
		specialOfferDiscount = new SpecialOfferDiscount(50, new Apples());
	}
	
	/**
	 * Test the handling of special offer discount
	 */
	@Test
	public void testHandleSpecialOfferDiscount(){
		
		Map<SpecialOffer, BigDecimal> specialOffersApplied = new HashMap<SpecialOffer, BigDecimal>(); 
				
		specialOffersApplied = specialOfferDiscount.handleSpecialOffer(specialOffersApplied);
		
		assertEquals(new BigDecimal(0.5),specialOffersApplied.get(specialOfferDiscount));
		
	}
}
