/**
 * 
 */
package com.mycompany.basket_price.goods;

import java.math.BigDecimal;

import com.mycompany.basket_price.PricedBasketItem;

/**
 * @author colin
 *
 */
public class Milk extends PricedBasketItem{

	public Milk() {
		setItemName(this.getClass().getSimpleName());
		setPrice(new BigDecimal(1.30));
	}

}
