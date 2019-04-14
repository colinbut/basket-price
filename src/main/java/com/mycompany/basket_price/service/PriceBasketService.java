/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.service;

/**
 * PriceBasketService - a service providing ability to get a list of 
 * the priced basket items
 * 
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
