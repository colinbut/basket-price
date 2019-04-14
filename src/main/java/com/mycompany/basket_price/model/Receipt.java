/*
 * |-------------------------------------------------
 * | Copyright © 2015 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * An object to represent the idea of a 'Receipt'
 * 
 * @author colin
 *
 */
public class Receipt {

	private List<PricedBasketItem> items;
	private Map<SpecialOffer, BigDecimal> specialOffersApplied;
	private BigDecimal subtotal;
	private BigDecimal total;
	
	/**
	 * Constructor
	 * 
	 * @param items
	 * @param specialOffersApplied
	 * @param subtotal
	 * @param total
	 */
	public Receipt(List<PricedBasketItem> items,
			Map<SpecialOffer, BigDecimal> specialOffersApplied,
			BigDecimal subtotal, BigDecimal total) {
		super();
		this.items = items;
		this.specialOffersApplied = specialOffersApplied;
		this.subtotal = subtotal;
		this.total = total;
	}


	/**
	 * Get the list of items in the basket
	 * 
	 * @return the items
	 */
	public List<PricedBasketItem> getItems() {
		return items;
	}
	
	
	/**
	 * Get a mappings of special offers with the quantity
	 * 
	 * @return the specialOffersApplied
	 */
	public Map<SpecialOffer, BigDecimal> getSpecialOffersApplied() {
		return specialOffersApplied;
	}
	
	
	/**
	 * Gets the subtotal (before any deductions of special offers) of the
	 * goods
	 * 
	 * @return the subtotal
	 */
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	
	/**
	 * Gets the total of all the goods (after deduction of special offers)
	 * 
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}
	
	/**
	 * The Builder design pattern
	 * 
	 * @author colin
	 *
	 */
	public static class ReceiptBuilder {
		
		private List<PricedBasketItem> items;
		private Map<SpecialOffer, BigDecimal> specialOffersApplied;
		private BigDecimal subtotal;
		private BigDecimal total;
		
		/**
		 * Adds items
		 * 
		 * @param items
		 * @return ReceiptBuilder
		 */
		public ReceiptBuilder withItems(final List<PricedBasketItem> items){
			this.items = items;
			return this;
		}
		
		/**
		 * Adds special offers
		 * 
		 * @param specialOffers
		 * @return ReceiptBuilder
		 */
		public ReceiptBuilder withSpecialOffersApplied(Map<SpecialOffer, BigDecimal> specialOffers){
			this.specialOffersApplied = specialOffers;
			return this;
		}
		
		/**
		 * Adds subtotal
		 * 
		 * @param subTotal
		 * @return ReceiptBuilder
		 */
		public ReceiptBuilder withSubTotal(BigDecimal subTotal){
			this.subtotal = subTotal;
			return this;
		}
		
		/**
		 * Adds total
		 * 
		 * @param total
		 * @return ReceiptBuilder
		 */
		public ReceiptBuilder withTotal(BigDecimal total){
			this.total = total;
			return this;
		}
		
		/**
		 * Builds the object
		 * 
		 * @return Receipt 
		 */
		public Receipt build(){
			if(items == null || specialOffersApplied == null 
					|| subtotal == null || total == null) {
				throw new IllegalArgumentException("Unable to construct Receipt - not all +"
						+ "properties set");
			}
			
			return new Receipt(this.items, this.specialOffersApplied, this.subtotal, this.total);
		}
		
	}
	
}
