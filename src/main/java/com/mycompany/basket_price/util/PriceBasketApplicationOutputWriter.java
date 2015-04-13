/**
 * 
 */
package com.mycompany.basket_price.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;


/**
 * @author colin
 *
 */
public class PriceBasketApplicationOutputWriter {

	public static String writeOutput(){
		
		DecimalFormat decimalFormattedText = new DecimalFormat("##.00");
		
		BigDecimal subtotal = new BigDecimal(3.10);
		BigDecimal specialOffer = new BigDecimal(0.10);
		BigDecimal total = new BigDecimal(3.00);
		String item = "Apples";
		int discount = 10; //in %
		
		StringBuilder sb = new StringBuilder();
		sb.append("Subtotal: £" + subtotal);
		
		sb.append(item + " " + discount + "% off: -" 
					+ (specialOffer.doubleValue() > 1.00 
							? "£"+decimalFormattedText.format(specialOffer.doubleValue()) 
							: decimalFormattedText.format(specialOffer.doubleValue())+"p"));
		
		sb.append("Total: £" + total);
		
		return sb.toString();
		
	}
	
	
}
