/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.lang.IllegalArgumentException
import java.math.BigDecimal

data class SpecialOfferBuy2Get1HalfPriceK(val halfPriceItem: PriceBasketItemK,
                                            private val buy2Item: PriceBasketItemK) : SpecialOfferK {


    override fun handleSpecialOffer(vararg varargs: Any): Map<SpecialOfferK, BigDecimal> {
        if (varargs.size != 3) {
            throw IllegalArgumentException("Incorrect argument values supplied")
        }

        val specialOffersApplied : MutableMap<SpecialOfferK, BigDecimal> = varargs[0] as MutableMap<SpecialOfferK, BigDecimal>
        val basketOfItems : PriceBasketK = varargs[1] as PriceBasketK
        val quantity = basketOfItems.getBasketItems()[varargs[2]]!!.toInt()

        if (quantity >= 2) {
            if (basketOfItems.basketContainItem(halfPriceItem)) {
                val moneyToTakeOff : Double = halfPriceItem.price.toDouble() / 2
                specialOffersApplied[this] = BigDecimal.valueOf(moneyToTakeOff)
            }
        }
        return specialOffersApplied
    }

    override fun getItemOnSpecialOffer(): PriceBasketItemK {
        return buy2Item
    }

}