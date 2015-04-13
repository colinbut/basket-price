/**
 * 
 */
package com.mycompany.basket_price.util;

import com.mycompany.basket_price.model.BasketItemStoreFactory;
import com.mycompany.basket_price.model.PriceBasket;


/**
 * A class that is responsible for capturing user entered input
 * 
 * @author colin
 *
 */
public class PriceBasketApplicationInputReader {

	/**
	 * Reads data from command line (args) and put into a PriceBasket object 
	 * which contains a mappings of goods and their quantity
	 * 
	 * This method asks the BasketItemStoreFactory class to retrieve a list
	 * of stored specific data objects (BasketItems). This is an implementation
	 * of the Factory Pattern (Simple Factory) where it adopts a naive approach.
	 * note* needs Enhancement later on...
	 * 
	 * 
	 * @param args
	 * @return PriceBasket containing items and their quantity
	 */
	public static PriceBasket readInputFromCommandLine(String[] args){
		
		PriceBasket basket = new PriceBasket();
		
		/* atm this is only for info purposes - will think of way to use this
		 * later on */
		String applicationName = args[0]; // this is ignored
		
		for(int i = 1; i < args.length; i++){
			basket.putItemInBasket(
					BasketItemStoreFactory.getBasketItem(args[i]));
		}
		
		return basket;
		
	}
}