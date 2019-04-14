/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model.goods;

import java.math.BigDecimal;

import com.mycompany.basket_price.model.PricedBasketItem;

/**
 * Apples
 * 
 * @author colin
 *
 */
public class Apples extends PricedBasketItem {

	/**
	 * Constructor
	 */
	public Apples() {
		setItemName(this.getClass().getSimpleName());
		setPrice(new BigDecimal(1.00));
	}

}
