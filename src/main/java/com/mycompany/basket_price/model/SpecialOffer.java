/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 * An interface for representing the Special Offer
 * 
 * @author colin
 *
 */
public interface SpecialOffer {
	
	/**
	 * Gets the special offer item
	 * 
	 * @return an item that is part of a special offering
	 */
	BasketItem getItemOnSpecialOffer();
	
	/**
	 * Callback method for SpecialOffer to handle what/how to do the special
	 * offer processing
	 * 
	 * @param args varargs
	 * @return map of special offers
	 */
	Map<SpecialOffer, BigDecimal> handleSpecialOffer(Object...args);
}
