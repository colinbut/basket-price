/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model.goods;

import java.math.BigDecimal;

import com.mycompany.basket_price.model.PricedBasketItem;

/**
 * Breads
 * 
 * @author colin
 *
 */
public class Bread extends PricedBasketItem{

	/**
	 * Constructor
	 */
	public Bread() {
		setItemName(this.getClass().getSimpleName());
		setPrice(new BigDecimal(0.80));
	}

}
