/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.lang.IllegalArgumentException
import java.math.BigDecimal

data class SpecialOfferDiscountK(var discount: Double,
                                 private var item: BasketItemK) : SpecialOfferK {

    override fun getItemOnSpecialOffer(): BasketItemK {
        return item
    }

    override fun handleSpecialOffer(vararg varargs: Any): Map<SpecialOfferK, BigDecimal> {
        if (varargs.size != 1) {
            throw IllegalArgumentException("Incorrect argument values supplied")
        }

        val specialOffersApplied : MutableMap<SpecialOfferK, BigDecimal> = varargs[0] as MutableMap<SpecialOfferK, BigDecimal>

        val discount = this.discount
        val moneyOff = item.getItemPrice().toDouble() * (discount / 100)

        specialOffersApplied.put(this, BigDecimal.valueOf(moneyOff))
        return specialOffersApplied
    }

}