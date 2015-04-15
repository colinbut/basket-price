/**
 * 
 */
package com.mycompany.basket_price.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

import com.mycompany.basket_price.model.Receipt;
import com.mycompany.basket_price.model.SpecialOffer;
import com.mycompany.basket_price.model.SpecialOfferBuy2Get1HalfPrice;
import com.mycompany.basket_price.model.SpecialOfferDiscount;


/**
 * @author colin
 *
 */
public class PriceBasketApplicationOutputWriter {

	public static String writeOutput(Receipt receipt){
		
		DecimalFormat decimalFormattedText = new DecimalFormat("##.00");
		
//		BigDecimal subtotal = new BigDecimal(3.10);
//		BigDecimal specialOffer = new BigDecimal(0.10);
//		BigDecimal total = new BigDecimal(3.00);
//		String item = "Apples";
//		int discount = 10; //in %
		
		BigDecimal subtotal = receipt.getSubtotal();
		BigDecimal total = receipt.getTotal();
		
		StringBuilder specialOfferSb = new StringBuilder();
		if(receipt.getSpecialOffersApplied().size() == 0){
			specialOfferSb.append("(No offers available)");
		}
		else{
			
			for(Map.Entry<SpecialOffer, BigDecimal> entry 
					: receipt.getSpecialOffersApplied().entrySet()){
				
				if(entry.getKey() instanceof SpecialOfferDiscount){
					SpecialOfferDiscount sod = (SpecialOfferDiscount)entry.getKey();
					specialOfferSb.append(sod.getItemOnSpecialOffer()+"\n");
					specialOfferSb.append(" " + sod.getDiscount() + "% off:");
					specialOfferSb.append("-" + ((entry.getValue().doubleValue() > 1.00) 
												? "£"+entry.getValue().doubleValue()
												: entry.getValue().doubleValue()+"p"));
					specialOfferSb.append("\n");
				}
				else if(entry.getKey() instanceof SpecialOfferBuy2Get1HalfPrice){
					//TODO: to implement
				}
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Subtotal: £" + subtotal + "\n");
		sb.append(specialOfferSb.toString());
		sb.append("Total: £" + total + "\n");
		
		return sb.toString();
		
	}
	
	
}
