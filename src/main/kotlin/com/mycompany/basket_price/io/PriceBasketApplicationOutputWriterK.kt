/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.io

import com.mycompany.basket_price.model.ReceiptK
import com.mycompany.basket_price.model.SpecialOfferBuy2Get1HalfPriceK
import com.mycompany.basket_price.model.SpecialOfferDiscountK
import java.lang.StringBuilder
import java.math.RoundingMode

object PriceBasketApplicationOutputWriterK {

    private const val NEWLINE_SEPARATOR : String = "\n"

    fun writeOutput(receipt: ReceiptK) : String {
        val subtotal = receipt.subtotal.setScale(2, RoundingMode.HALF_EVEN)
        val total = receipt.total.setScale(2, RoundingMode.HALF_EVEN)

        val specialOfferSb = StringBuilder()

        if (receipt.specialOffersApplied.isEmpty()) {
            specialOfferSb.append("No Offers available")
        } else {
            for (entry in receipt.specialOffersApplied) {
                if (entry.key is SpecialOfferDiscountK) {
                    val specialOfferDiscount : SpecialOfferDiscountK = entry.key as SpecialOfferDiscountK
                    specialOfferSb.append(specialOfferDiscount.getItemOnSpecialOffer().name)
                    specialOfferSb.append(" " + specialOfferDiscount.discount + "%s off: ")
                    specialOfferSb.append("-" + if (entry.value.toDouble() > 1.00) {
                        "£${entry.value.setScale(2, RoundingMode.HALF_EVEN)}"
                    } else {
                        entry.value.setScale(2, RoundingMode.HALF_EVEN)
                    })
                } else if (entry.key is SpecialOfferBuy2Get1HalfPriceK) {
                    val sob2g1hp : SpecialOfferBuy2Get1HalfPriceK = entry.key as SpecialOfferBuy2Get1HalfPriceK
                    specialOfferSb.append("Buy 2 ${sob2g1hp.getItemOnSpecialOffer().name}")
                    specialOfferSb.append(" get ${sob2g1hp.halfPriceItem.name}")
                    specialOfferSb.append("-" + if (entry.value.toDouble() > 1.00) {
                        "£${entry.value.setScale(2, RoundingMode.HALF_EVEN)}"
                    } else {
                        "${entry.value.setScale(2, RoundingMode.HALF_EVEN)}"
                    })
                }
            }
        }

        val sb = StringBuilder()
        sb.append("Subtotal: £$subtotal$NEWLINE_SEPARATOR")
        sb.append(specialOfferSb.toString())
        sb.append("Total: £$total$NEWLINE_SEPARATOR")

        return sb.toString()
    }
}