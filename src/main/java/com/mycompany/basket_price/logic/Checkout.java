/**
 * 
 */
package com.mycompany.basket_price.logic;

import com.mycompany.basket_price.model.Receipt;

/**
 * Abstract entity representing the 'Checkout'
 * 
 * @author colin
 *
 */
public abstract class Checkout {

	/**
	 * 
	 * @return
	 */
	public abstract Receipt getReceipt();
	
	/**
	 * 
	 * @return
	 */
	public abstract void calculateSubTotal();
	
	/**
	 * 
	 * @return
	 */
	public abstract void calculateTotal();
	
	/**
	 * 
	 */
	public abstract void applySpecialOffers();
	
	/**
	 * The "Template Method" design pattern
	 */
	public final Checkout checkout(){
		
		calculateSubTotal();
		
		applySpecialOffers();
		
		calculateTotal();
		
		return this;
		
	}
}
