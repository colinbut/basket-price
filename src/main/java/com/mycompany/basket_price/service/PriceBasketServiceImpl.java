/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.service;

import com.mycompany.basket_price.logic.PriceBasketCheckout;
import com.mycompany.basket_price.model.Receipt;
import com.mycompany.basket_price.util.PriceBasketApplicationOutputWriter;

/**
 * Implementation of the PriceBasketService interface
 * 
 * @author colin
 *
 */
public class PriceBasketServiceImpl implements PriceBasketService{

	private PriceBasketCheckout checkoutTill;
	
	/**
	 * Constructor
	 */
	public PriceBasketServiceImpl() {
		// 
	}
	
	/**
	 * Sets the PriceBasketCheckout
	 * 
	 * @param checkout the checkout object to set
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
		Receipt receipt = checkoutTill.checkout().generateReceipt(); 
		return PriceBasketApplicationOutputWriter.writeOutput(receipt);
	}

}
