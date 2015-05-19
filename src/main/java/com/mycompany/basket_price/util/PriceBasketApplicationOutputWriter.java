/**
 * 
 */
package com.mycompany.basket_price.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import com.mycompany.basket_price.model.Receipt;
import com.mycompany.basket_price.model.SpecialOffer;
import com.mycompany.basket_price.model.SpecialOfferBuy2Get1HalfPrice;
import com.mycompany.basket_price.model.SpecialOfferDiscount;


/**
 * Utility class to write the results in a format that is desired
 * 
 * @author colin
 *
 */
public class PriceBasketApplicationOutputWriter {

	private static final String NEWLINE_SEPARATOR = "\n";
	
	private PriceBasketApplicationOutputWriter() {}
	
	/**
	 * Writes the output in a format
	 * 
	 * @param receipt the Receipt object containing the details to format
	 * @return formatted price in a String format
	 */
	public static String writeOutput(Receipt receipt){
		
		BigDecimal subtotal = receipt.getSubtotal().setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal total = receipt.getTotal().setScale(2, RoundingMode.HALF_EVEN);
		
		StringBuilder specialOfferSb = new StringBuilder();
		
		if(receipt.getSpecialOffersApplied().size() == 0){
			specialOfferSb.append("(No offers available)");
		}
		else{
			
			for(Map.Entry<SpecialOffer, BigDecimal> entry : receipt.getSpecialOffersApplied().entrySet()){
				
				if(entry.getKey() instanceof SpecialOfferDiscount){
					SpecialOfferDiscount specialOfferDiscount = (SpecialOfferDiscount)entry.getKey();
					
					specialOfferSb.append(specialOfferDiscount.getItemOnSpecialOffer().getItemName());
					specialOfferSb.append(" " + specialOfferDiscount.getDiscount() + "% off: ");
					specialOfferSb.append("-" + ((entry.getValue().doubleValue() > 1.00) 
												? "£"+entry.getValue().setScale(2, RoundingMode.HALF_EVEN)
												: entry.getValue().setScale(2, RoundingMode.HALF_EVEN)+"p"));
					specialOfferSb.append(NEWLINE_SEPARATOR);
				}
				else if(entry.getKey() instanceof SpecialOfferBuy2Get1HalfPrice){
					
					SpecialOfferBuy2Get1HalfPrice sob2g1hp = (SpecialOfferBuy2Get1HalfPrice) entry.getKey();
					
					specialOfferSb.append("Buy 2 " + sob2g1hp.getItemOnSpecialOffer().getItemName());
					specialOfferSb.append(" get " + sob2g1hp.getHalfPriceItem().getItemName() + " half price: ");
					specialOfferSb.append("-" + ((entry.getValue().doubleValue() > 1.00) 
							? "£"+entry.getValue().setScale(2, RoundingMode.HALF_EVEN)
							: entry.getValue().setScale(2, RoundingMode.HALF_EVEN)+"p"));
					specialOfferSb.append(NEWLINE_SEPARATOR);
				}
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Subtotal: £" + subtotal + NEWLINE_SEPARATOR);
		sb.append(specialOfferSb.toString());
		sb.append("Total: £" + total + NEWLINE_SEPARATOR);
		
		return sb.toString();
		
	}
	
	
}
