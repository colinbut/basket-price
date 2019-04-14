/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model.goods;

import java.math.BigDecimal;

import com.mycompany.basket_price.model.PricedBasketItem;

/**
 * Milk
 * 
 * @author colin
 *
 */
public class Milk extends PricedBasketItem{
	
	/**
	 * Constructor
	 */
	public Milk() {
		setItemName(this.getClass().getSimpleName());
		setPrice(new BigDecimal(1.30));
	}

}
