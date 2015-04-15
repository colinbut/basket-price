/**
 * 
 */
package com.mycompany.basket_price.model;

/**
 * @author colin
 *
 */
public class SpecialOfferBuy2Get1HalfPrice implements SpecialOffer{

	private BasketItem buy2Item;
	private BasketItem halfPriceItem;
	
	
	/**
	 * Constructor
	 * 
	 * @param buy2Item
	 * @param halfPriceItem
	 */
	public SpecialOfferBuy2Get1HalfPrice(BasketItem buy2Item,
			BasketItem halfPriceItem) {
		this.buy2Item = buy2Item;
		this.halfPriceItem = halfPriceItem;
	}
	/**
	 * @return the buy2Item
	 */
	public BasketItem getBuy2Item() {
		return buy2Item;
	}
	/**
	 * @param buy2Item the buy2Item to set
	 */
	public void setBuy2Item(BasketItem buy2Item) {
		this.buy2Item = buy2Item;
	}
	/**
	 * @return the halfPriceItem
	 */
	public BasketItem getHalfPriceItem() {
		return halfPriceItem;
	}
	/**
	 * @param halfPriceItem the halfPriceItem to set
	 */
	public void setHalfPriceItem(BasketItem halfPriceItem) {
		this.halfPriceItem = halfPriceItem;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.model.SpecialOffer#getItemOnSpecialOffer()
	 */
	@Override
	public BasketItem getItemOnSpecialOffer() {
		return getBuy2Item();
	}
	
	
}
