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

		// TODO: rewrite this later
		Map<SpecialOffer, BigDecimal> specialOffersApplied = new HashMap<SpecialOffer, BigDecimal>();

		for (BasketItem item : basketOfItems.getBasketItems().keySet()) {

			for (int i = 0; i < specialOffersInStore.size(); i++) {
				if (specialOffersInStore.get(i).getItemOnSpecialOffer()
						.getClass().isInstance(item)) {

					// TODO: re-code this using handlers maybe

					if (specialOffersInStore.get(i) instanceof SpecialOfferDiscount) {

						SpecialOfferDiscount sod = (SpecialOfferDiscount) specialOffersInStore
								.get(i);

						double discount = sod.getDiscount();
						double moneyOff = item.getPrice().doubleValue()
								* (discount / 100);

						specialOffersApplied.put(sod, new BigDecimal(moneyOff));

					} else if (specialOffersInStore.get(i) instanceof SpecialOfferBuy2Get1HalfPrice) {

						SpecialOfferBuy2Get1HalfPrice sob2g1hp = (SpecialOfferBuy2Get1HalfPrice) specialOffersInStore
								.get(i);

						int quantity = basketOfItems.getBasketItems().get(item);
						if (quantity >= 2) {

							if (basketOfItems.basketContainItem(sob2g1hp
									.getHalfPriceItem())) {

								double moneyToTakeOff = sob2g1hp
										.getHalfPriceItem().getPrice()
										.doubleValue() / 2;
								specialOffersApplied.put(sob2g1hp,
										new BigDecimal(moneyToTakeOff));

							} else {
								// no special offer applied too as has not
								// bought the
								// item being offered half price
							}
						} else {
							// no special offer applied as has not bought enough
							// of the
							// specialed offered item
						}

					}
				}
			}

		}
		
		
		this.specialOffersApplied = specialOffersApplied;
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
