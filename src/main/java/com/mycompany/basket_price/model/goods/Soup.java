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
public class Soup extends PricedBasketItem{

	public Soup() {
		setItemName(this.getClass().getSimpleName());
		setPrice(new BigDecimal(0.65));
	}

}
