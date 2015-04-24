/**
 * 
 */
package com.mycompany.basket_price.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Singleton
 * 
 * A store entity. For this application there is only one store
 * 
 * @author colin
 *
 */
public class PriceBasketApplicationStore {

	private static PriceBasketApplicationStore INSTANCE;
	
	private BasketItemStoreFactory storeFactory;
	private List<SpecialOffer> specialOffersInStore; //this week
	
	/*
	 * Constructor
	 */
	private PriceBasketApplicationStore(){
		// Singleton Design Pattern implementation
		specialOffersInStore = new ArrayList<>();
		storeFactory = new BasketItemStoreFactory();
		configureSpecialOffersInStoreIntoSystem();
	}
	
	/*
	 * Sets up the special offers for this week
	 * 
	 * atm - this is hardcoded - need to modify this into a more flexible
	 * runtime solution
	 * 
	 */
	private void configureSpecialOffersInStoreIntoSystem(){
		
		//TODO: use a better way to associate items with SpecialOffers
		
		specialOffersInStore.add(new SpecialOfferDiscount(10.0, 
				storeFactory.getBasketItem("Apples")));
		
		specialOffersInStore.add(new SpecialOfferBuy2Get1HalfPrice(
				storeFactory.getBasketItem("Soup"),
				storeFactory.getBasketItem("Bread")));
		
	}
	
	/**
	 * Returns an instance of PriceBasketApplicationStore
	 * 
	 * The idea is that there can only be only ONE store for this 
	 * 'Application'
	 * 
	 * @return instance of this
	 */
	public static PriceBasketApplicationStore getInstance(){
		if(INSTANCE == null){
			INSTANCE = new PriceBasketApplicationStore();
		}
		return INSTANCE;
	}
	
	/**
	 * Gets the factory object used to create the items
	 * 
	 * @return store factory
	 */
	public BasketItemStoreFactory getFactory(){
		return storeFactory;
	}
	
	/**
	 * Gets a list of the special offers that is on offer
	 * 
	 * @return list of special offers
	 */
	public List<SpecialOffer> getStoreSpecialOffers(){
		return specialOffersInStore;
	}
	
	
}
