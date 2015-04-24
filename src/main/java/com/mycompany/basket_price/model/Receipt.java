/**
 * 
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
	 * Get the list of items in the basket
	 * 
	 * @return the items
	 */
	public List<PricedBasketItem> getItems() {
		return items;
	}
	
	/**
	 * Sets the items basket
	 * 
	 * @param items the items to set
	 */
	public void setItems(List<PricedBasketItem> items) {
		this.items = items;
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
	 * @param specialOffersApplied the specialOffersApplied to set
	 */
	public void setSpecialOffersApplied(Map<SpecialOffer, BigDecimal> specialOffersApplied) {
		this.specialOffersApplied = specialOffersApplied;
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
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
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
	 * @param total the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
	
}
