/**
 * 
 */
package com.mycompany.basket_price.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.basket_price.model.BasketItem;
import com.mycompany.basket_price.model.PriceBasket;
import com.mycompany.basket_price.model.PriceBasketApplicationStore;
import com.mycompany.basket_price.model.PricedBasketItem;
import com.mycompany.basket_price.model.Receipt;
import com.mycompany.basket_price.model.SpecialOffer;
import com.mycompany.basket_price.model.SpecialOfferBuy2Get1HalfPrice;
import com.mycompany.basket_price.model.SpecialOfferDiscount;
import com.mycompany.basket_price.model.Receipt.ReceiptBuilder;

/**
 * An implementation of Checkout abstract class
 * 
 * @author colin
 *
 */
public class PriceBasketCheckout extends Checkout{

	private PriceBasket basketOfItems;

	private BigDecimal subTotal;
	private BigDecimal total;
	private Map<SpecialOffer, BigDecimal> specialOffersApplied;


	/**
	 * Constructor
	 * 
	 * @param basket
	 */
	public PriceBasketCheckout(PriceBasket basket) {
		basketOfItems = basket;
		specialOffersApplied = new HashMap<SpecialOffer, BigDecimal>();
	}
	
	/**
	 * @return the subTotal
	 */
	public BigDecimal getSubTotal() {
		return subTotal;
	}


	/**
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}


	/**
	 * @return the specialOffersApplied
	 */
	public Map<SpecialOffer, BigDecimal> getSpecialOffersApplied() {
		return specialOffersApplied;
	}

	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.logic.Checkout#calculateSubTotal()
	 */
	@Override
	public void calculateSubTotal() {

		Map<BasketItem, Integer> items = basketOfItems.getBasketItems();

		double subtotal = 0.0;

		for (Map.Entry<BasketItem, Integer> item : items.entrySet()) {

			subtotal += item.getKey().getPrice().doubleValue()
					* item.getValue().intValue();

		}

		subTotal = new BigDecimal(subtotal);

	}


	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.logic.Checkout#applySpecialOffers()
	 */
	@Override
	public void applySpecialOffers() {
		
		// get special offers & apply them to items bought

		List<SpecialOffer> specialOffersInStore = PriceBasketApplicationStore
				.getInstance().getStoreSpecialOffers();

		for (BasketItem item : basketOfItems.getBasketItems().keySet()) {

			for (int i = 0; i < specialOffersInStore.size(); i++) {
				
				SpecialOffer specialOffer = specialOffersInStore.get(i);
				
				if (specialOffer.getItemOnSpecialOffer().getClass().isInstance(item)) {

					if (specialOffer instanceof SpecialOfferDiscount) {
						specialOffer.handleSpecialOffer(specialOffersApplied);
					} 
					else if (specialOffer instanceof SpecialOfferBuy2Get1HalfPrice) {
						specialOffer.handleSpecialOffer(specialOffersApplied, basketOfItems, item);
					}
					
				}
			}

		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.logic.Checkout#calculateTotal()
	 */
	@Override
	public void calculateTotal() {

		double totalMoneyOff = 0.0;

		for (Map.Entry<SpecialOffer, BigDecimal> entry : specialOffersApplied
				.entrySet()) {
			totalMoneyOff += entry.getValue().doubleValue();
		}

		total = new BigDecimal(subTotal.doubleValue()
				- totalMoneyOff);

	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.basket_price.logic.Checkout#generateReceipt()
	 */
	@Override
	public Receipt generateReceipt() {
		
		return new ReceiptBuilder().withItems(new ArrayList<PricedBasketItem>())
				.withSpecialOffersApplied(specialOffersApplied)
				.withSubTotal(subTotal)
				.withTotal(total)
				.build();
		
	}
}
