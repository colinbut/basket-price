/**
 * 
 */
package com.mycompany.basket_price.model;

/**
 * An interface for representing the Special Offer
 * 
 * @author colin
 *
 */
public interface SpecialOffer {

	//TODO: change this SpecialOffer model to be more flexible in future
	// for now it is ok
	
	/**
	 * Gets the special offer item
	 * 
	 * @return an item that is part of a special offering
	 */
	BasketItem getItemOnSpecialOffer();
}
