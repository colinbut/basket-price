/**
 * 
 */
package com.mycompany.basket_price.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mycompany.basket_price.model.Receipt.ReceiptBuilder;
import com.mycompany.basket_price.model.goods.Apples;
import com.mycompany.basket_price.model.goods.Bread;
import com.mycompany.basket_price.model.goods.Milk;
import com.mycompany.basket_price.model.goods.Soup;

/**
 * @author colin
 *
 */
public class ReceiptTest {

	private ReceiptBuilder receiptBuilder;
	
	@Before
	public void setUp(){
		receiptBuilder = new ReceiptBuilder();
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testReceiptBuilderBuildNotProperly(){
		receiptBuilder.build();		
	}
	
	@Test
	public void testReceiptBuilderBuildSuccess(){
		
		@SuppressWarnings("serial")
		Receipt receipt = receiptBuilder.withSubTotal(new BigDecimal(2.00))
						.withTotal(new BigDecimal(3.00))
						.withItems(new ArrayList<PricedBasketItem>()
								{
									{
										add(new Apples());
										add(new Bread());
										add(new Milk());
										add(new Soup());
									}
								}
								)
						.withSpecialOffersApplied(new HashMap<SpecialOffer, BigDecimal>()
								{
									{
										put(new SpecialOfferDiscount(20.0, new Apples()), new BigDecimal(1.0));
									}
								}
							).build();
		
		
		assertTrue(receipt instanceof Receipt);
		
		List<PricedBasketItem> items = receipt.getItems();
		Map<SpecialOffer, BigDecimal> specialOffersApplied = receipt.getSpecialOffersApplied();
		
		BigDecimal subTotal = receipt.getSubtotal();
		BigDecimal total = receipt.getTotal();
		
		assertEquals(new BigDecimal(2.00), subTotal);
		assertEquals(new BigDecimal(3.00), total);
		
		for(PricedBasketItem item : items){
			// TODO
		}
		
		
	}
	
	
}
