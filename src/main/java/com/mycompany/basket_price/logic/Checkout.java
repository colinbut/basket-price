/**
 * 
 */
package com.mycompany.basket_price.logic;

import com.mycompany.basket_price.model.Receipt;

/**
 * Abstract entity representing the 'Checkout'.
 * 
 * This is constructed as a 'Template Method' design pattern where the 
 * procedure of checkout is set in stone. Implementing classes (subclasses) can of course
 * override all the individual methods (hooks) of the checkout procedure (i.e. the algorithm). 
 * 
 * This entity ultimately returns a Receipt which contains information about the checked out 
 * items of goods in a "Receipt" form. 
 * Note* at the moment - This is constructed partially using the 'Builder' design pattern to build
 * up the Receipt. This area needs refinement.  
 * 
 * @author colin
 *
 */
public abstract class Checkout {
	
	/**
	 * Calculates the subtotal of all the items of goods.
	 * This calculated total is the before special offers deduction.
	 * 
	 * @return the subtotal (before any deductions)
	 */
	public abstract void calculateSubTotal();
	
	/**
	 * Calculates the total of the items of goods.
	 * This takes into account of the special offers in place and applies
	 * the special offers which is then subtracted from the subtotal
	 * 
	 * @return the total (after special offer deductions) 
	 */
	public abstract void calculateTotal();
	
	/**
	 * Puts in place the special offers towards the items of goods 
	 * in the pricing basket
	 */
	public abstract void applySpecialOffers();
	
	/**
	 * Gets the receipt after checking out the items of goods
	 * 
	 * @return the receipt
	 */
	public abstract Receipt generateReceipt();
	
	/**
	 * The "Template Method" design pattern
	 */
	public final Checkout checkout(){
		
		// first calculates the total of all items
		// not taking account of any offers i.e. their default prices etc...
		calculateSubTotal();
		
		// subtract any money off as part of special offers
		applySpecialOffers();
		
		// finally, present total cost (after special offers deduction)
		calculateTotal();
		
		return this;
		
	}
}
