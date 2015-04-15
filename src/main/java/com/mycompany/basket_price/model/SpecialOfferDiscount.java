/**
 * 
 */
package com.mycompany.basket_price.model;

/**
 * @author colin
 *
 */
public class SpecialOfferDiscount implements SpecialOffer {

	private double discount; //%
	private BasketItem item;
	
	/**
	 * Constructor
	 * 
	 * @param discount
	 * @param item
	 */
	public SpecialOfferDiscount(double discount, BasketItem item){
		this.discount = discount;
		this.item = item;
	}
	
	
	/**
	 * @return the discount
	 */
	public double getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	/**
	 * @return the item
	 */
	public BasketItem getItem() {
		return item;
	}
	/**
	 * @param item the item to set
	 */
	public void setItem(BasketItem item) {
		this.item = item;
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.model.SpecialOffer#getItemOnSpecialOffer()
	 */
	@Override
	public BasketItem getItemOnSpecialOffer() {
		return getItem();
	}
	
	
}
