/**
 * 
 */
package com.mycompany.basket_price.logic;

import java.util.Map;

import com.mycompany.basket_price.model.BasketItem;
import com.mycompany.basket_price.model.PriceBasket;

/**
 * 
 * 
 * @author colin
 *
 */
public class PriceBasketCheckout {

	//TODO: this class hold info about any special offers
	
	private PriceBasket basketOfItems;
	
	/**
	 * Constructor
	 * 
	 * @param basket
	 */
	public PriceBasketCheckout(PriceBasket basket){
		basketOfItems = basket;
	}
	
	public void checkout(){
		calculateSubTotal();
	}
	
	private double calculateSubTotal(){
		
		
		Map<BasketItem, Integer> items = basketOfItems.getBasketItems();
		
		double total = 0.0;
		
		for(Map.Entry<BasketItem, Integer> item : items.entrySet()){
			
			total += item.getKey().getPrice().doubleValue() * item.getValue().intValue();
			
		}
		
		return total;
		
	}
}
