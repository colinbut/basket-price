/**
 * 
 */
package com.mycompany.basket_price.model;

import java.util.HashMap;
import java.util.Map;

/**
 * A basket of items 
 * 
 * @author colin
 *
 */
public class PriceBasket {

	// map of items in basket and how many of each item
	private Map<BasketItem, Integer> basketItems = null;
	
	/**
	 * Constructor
	 */
	public PriceBasket(){
		basketItems = new HashMap<>();
	}
	
	/**
	 * Puts an item into the basket
	 * 
	 * If there is already the same item in basket then increment the 
	 * quantity number
	 * 
	 * @param item to put in basket
	 */
	public void putItemInBasket(BasketItem item){
		basketItems.put(item, 1); //default 1 qty
	}
	
	/**
	 * Gets all the items in basket with the quantity
	 * 
	 * @return a map of items and their quantity in basket 
	 */
	public Map<BasketItem, Integer> getBasketItems(){
		return basketItems;
	}
}
