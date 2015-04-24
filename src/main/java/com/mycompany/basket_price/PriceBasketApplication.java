/**
 * 
 */
package com.mycompany.basket_price;

import com.mycompany.basket_price.logic.PriceBasketCheckout;
import com.mycompany.basket_price.model.PriceBasket;
import com.mycompany.basket_price.service.PriceBasketService;
import com.mycompany.basket_price.service.PriceBasketServiceImpl;
import com.mycompany.basket_price.util.PriceBasketApplicationInputReader;

/**
 * The Price Basket Application
 * 
 * @author colin
 *
 */
public class PriceBasketApplication {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		PriceBasketService priceBasketService = new PriceBasketServiceImpl();
		
		PriceBasket basket = PriceBasketApplicationInputReader.readInputFromCommandLine(args);
		
		// using Constructor DI
		PriceBasketCheckout checkout = new PriceBasketCheckout(basket);
		
		// using Setter DI
		((PriceBasketServiceImpl)priceBasketService).setPriceBasketCheckout(checkout);
		
		System.out.println(priceBasketService.getPriceOfBasketItems());
		
	}
}
