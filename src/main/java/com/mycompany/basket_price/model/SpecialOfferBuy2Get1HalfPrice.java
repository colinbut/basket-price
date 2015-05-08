/**
 * 
 */
package com.mycompany.basket_price.model;

import java.math.BigDecimal;
import java.util.Map;

/**
 * An implementation of the SpecialOffer interface to represent a particular 
 * deal of "Buy 2 get 1 half price"
 * 
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
	 * Gets the item that is required to be brought in 2 in order
	 * to qualify for a special offer 
	 * 
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
	 * Gets the item that is on offered to be half price
	 * 
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

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.model.SpecialOffer#handleSpecialOffer(java.lang.Object[])
	 */
	@Override
	public Map<SpecialOffer, BigDecimal> handleSpecialOffer(Object... args) {
		
		if(args.length != 3){
			throw new IllegalArgumentException("Incorrect argument values supplied");
		}
		
		@SuppressWarnings("unchecked")
		Map<SpecialOffer, BigDecimal> specialOffersApplied = (Map<SpecialOffer, BigDecimal>)args[0];
		PriceBasket basketOfItems = ((PriceBasket)args[1]);
		int quantity = basketOfItems.getBasketItems().get((BasketItem)args[2]).intValue();
		
		
		// bought enough items to satisfy special offer
		if (quantity >= 2) {

			// special offer applied, bought item at half price
			if (basketOfItems.basketContainItem(halfPriceItem)) {

				double moneyToTakeOff = halfPriceItem.getPrice().doubleValue() / 2;
				specialOffersApplied.put(this,new BigDecimal(moneyToTakeOff));

			} 
		} 
		
		return specialOffersApplied;
	}
	
	
}
