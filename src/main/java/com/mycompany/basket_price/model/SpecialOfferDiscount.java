/**
 * 
 */
package com.mycompany.basket_price.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 * An implementation of the SpecialOffer interface where it represents a 
 * deal of a "discount"ed offer
 * 
 * The discount is a % of the original price which is then taken off.
 * For e.g. 10% off!
 * 
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
	 * Gets the amount discounted in percentage
	 * 
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
	 * Gets the item
	 * 
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


	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.model.SpecialOffer#handleSpecialOffer(java.util.Map)
	 */
	@Override
	public Map<SpecialOffer, BigDecimal> handleSpecialOffer(Object...args) {
		
		if(args.length != 1){
			throw new IllegalArgumentException("Incorrect argument values supplied");
		}
		
		@SuppressWarnings("unchecked")
		Map<SpecialOffer, BigDecimal> specialOffersApplied = (Map<SpecialOffer, BigDecimal>)args[0];
		
		double discount = this.getDiscount();
		double moneyOff = item.getPrice().doubleValue() * (discount / 100);
		
		specialOffersApplied.put(this, new BigDecimal(moneyOff));
		return specialOffersApplied;
		
	}
	
	
}
