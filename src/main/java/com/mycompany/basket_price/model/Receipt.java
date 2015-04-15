/**
 * 
 */
package com.mycompany.basket_price.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author colin
 *
 */
public class Receipt {

	private List<PricedBasketItem> items;
	private Map<SpecialOffer, BigDecimal> specialOffersApplied;
	private BigDecimal subtotal;
	private BigDecimal total;
	
	/**
	 * @return the items
	 */
	public List<PricedBasketItem> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<PricedBasketItem> items) {
		this.items = items;
	}
	/**
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
