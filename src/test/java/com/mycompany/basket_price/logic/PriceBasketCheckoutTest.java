/**
 * 
 */
package com.mycompany.basket_price.logic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.mycompany.basket_price.model.BasketItem;
import com.mycompany.basket_price.model.PriceBasket;
import com.mycompany.basket_price.model.SpecialOffer;
import com.mycompany.basket_price.model.SpecialOfferDiscount;
import com.mycompany.basket_price.model.goods.Apples;
import com.mycompany.basket_price.model.goods.Bread;
import com.mycompany.basket_price.model.goods.Milk;
import com.mycompany.basket_price.model.goods.Soup;

/**
 * @author colin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PriceBasketCheckoutTest {

	@Mock(name="subTotal")
	private BigDecimal subtotal;
	
	@Mock
	private PriceBasket basketOfItems;
	
	@Mock
	private Map<SpecialOffer, BigDecimal> specialOffersApplied;
	
	@InjectMocks
	private PriceBasketCheckout priceBasketCheckout;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		priceBasketCheckout = new PriceBasketCheckout(basketOfItems);
		
		priceBasketCheckout.setSpecialOffersApplied(specialOffersApplied);
		priceBasketCheckout.setSubTotal(subtotal);
	}
	
	/**
	 * Test calculating the subtotal before any deductions of
	 * any special offers applied
	 */
	@Test
	public void testCalculateSubTotal(){
		
		Map<BasketItem, Integer> items = new HashMap<BasketItem, Integer>(){

			private static final long serialVersionUID = 1L;

			{
				put(new Apples(), 1); // £1.00
				put(new Apples(), 1); // £1.00
				put(new Soup(), 2);   // £0.65 each (£1.30)
				put(new Milk(), 1);   // £1.30
				put(new Bread(), 3);  // £0.80 each (£2.40)
				 
				// total = £7.00
			}
		};
		
		when(basketOfItems.getBasketItems()).thenReturn(items);
		
		priceBasketCheckout.calculateSubTotal();
		
		assertEquals(new BigDecimal(7.00), priceBasketCheckout.getSubTotal()); 
		
	}
	
	/**
	 * Test calculating the total amount
	 */
	@Test
	public void testCalculateTotal(){
		
		Map<SpecialOffer, BigDecimal> data = new HashMap<SpecialOffer, BigDecimal>(){

			private static final long serialVersionUID = 1L;

			{
				put(new SpecialOfferDiscount(30.0, new Apples()), new BigDecimal(1.00));
			}
		};
		
		when(specialOffersApplied.entrySet()).thenReturn(data.entrySet());
		when(subtotal.doubleValue()).thenReturn(5.00);
		
		priceBasketCheckout.calculateTotal();
		
		verify(specialOffersApplied, times(1)).entrySet();
		verify(subtotal, times(1)).doubleValue();
		
		assertEquals(new BigDecimal(4.00), priceBasketCheckout.getTotal());
		
		
	}
	
	/**
	 * Test the applying of special offers
	 */
	@Ignore
	@Test
	public void testApplySpecialOffers(){
		fail("Not Yet Implemented");
	}
	
}
