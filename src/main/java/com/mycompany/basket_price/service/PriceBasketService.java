/**
 * 
 */
package com.mycompany.basket_price.service;

/**
 * @author colin
 *
 */
public interface PriceBasketService {

	/**
	 * Gets the total pricing of the items in basket taking
	 * into account of any special offers
	 * 
	 * @return a receipt in a piece of String
	 */
	String getPriceOfBasketItems();
}
