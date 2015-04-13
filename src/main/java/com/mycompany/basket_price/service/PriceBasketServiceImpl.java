/**
 * 
 */
package com.mycompany.basket_price.service;

import com.mycompany.basket_price.logic.PriceBasketCheckout;
import com.mycompany.basket_price.util.PriceBasketApplicationOutputWriter;

/**
 * @author colin
 *
 */
public class PriceBasketServiceImpl implements PriceBasketService{

	private PriceBasketCheckout checkoutTill;
	
	public PriceBasketServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param checkout
	 */
	public void setPriceBasketCheckout(PriceBasketCheckout checkout){
		checkoutTill = checkout;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.service.PriceBasketService#getPriceOfBasketItems()
	 */
	@Override
	public String getPriceOfBasketItems() {
		
		checkoutTill.checkout(); //this needs to return something to pass down below
		// a receipt?
		return PriceBasketApplicationOutputWriter.writeOutput();
	}

}
