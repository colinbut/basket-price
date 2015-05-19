/**
 * 
 */
package com.mycompany.basket_price;

import com.mycompany.basket_price.exception.UnknownItemException;
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
	 * Processes the items and returns the pricing
	 * 
	 * @param args
	 * @return
	 */
	public String process(String[] args){
		
		PriceBasketService priceBasketService = new PriceBasketServiceImpl();
		
		try{
			PriceBasket basket = PriceBasketApplicationInputReader.readInputFromCommandLine(args);
			
			// using Constructor DI
			PriceBasketCheckout checkout = new PriceBasketCheckout(basket);
			
			// using Setter DI
			((PriceBasketServiceImpl)priceBasketService).setPriceBasketCheckout(checkout);
			
		}
		catch(UnknownItemException e){
			System.err.println("Unknown Item in store");
		}
		
		return priceBasketService.getPriceOfBasketItems();
	}
	
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		PriceBasketApplication app = new PriceBasketApplication();
		System.out.println(app.process(args));
		
	}
}
