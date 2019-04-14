/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model;

import java.math.BigDecimal;

/**
 * Interface that represents an item in basket
 * 
 * @author colin
 *
 */
public interface BasketItem {

	/**
	 * Gets the name of the item in basket
	 * 
	 * @return name of item
	 */
	String getItemName();
	
	/**
	 * Sets the name of item in basket
	 * 
	 * @param name of item
	 */
	void setItemName(String name);
	
	/**
	 * Gets the price of item in basket
	 * 
	 * @return price of item
	 */
	BigDecimal getPrice();
	
	/**
	 * Sets the price of item in basket
	 * 
	 * @param price of item 
	 */
	void setPrice(BigDecimal price);
}
