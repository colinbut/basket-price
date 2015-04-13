/**
 * 
 */
package com.mycompany.basket_price.model;

import java.math.BigDecimal;

/**
 * An implementation of the BasketItem interface where an item in the 
 * basket can be priced
 * 
 * @author colin
 *
 */
public class PricedBasketItem implements BasketItem{

	private String name;
	private BigDecimal price;
	
	/**
	 * Constructor
	 * 
	 * @param name of item
	 * @param price of item
	 */
	public PricedBasketItem(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * Constructor
	 */
	public PricedBasketItem(){
		//
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.BasketItem#getItemName()
	 */
	@Override
	public String getItemName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.BasketItem#setItemName(java.lang.String)
	 */
	@Override
	public void setItemName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.BasketItem#getPrice()
	 */
	@Override
	public BigDecimal getPrice() {
		return price;
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.BasketItem#setPrice(java.math.BigDecimal)
	 */
	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
