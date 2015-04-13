/**
 * 
 */
package com.mycompany.basket_price.model.goods;

import java.math.BigDecimal;

import com.mycompany.basket_price.model.PricedBasketItem;

/**
 * @author colin
 *
 */
public class Apples extends PricedBasketItem {

	public Apples() {
		setItemName(this.getClass().getSimpleName());
		setPrice(new BigDecimal(1.00));
	}

}
