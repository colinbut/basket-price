/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.logic

import com.mycompany.basket_price.model.*
import java.math.BigDecimal

class PriceBasketCheckoutK(basketK: PriceBasketK) : CheckoutK() {

    private val basketOfItems : PriceBasketK = basketK
    var subTotal : BigDecimal = BigDecimal.ZERO
    private var total : BigDecimal = BigDecimal.ZERO
    private var specialOffersApplied : MutableMap<SpecialOfferK, BigDecimal> = HashMap()

    override fun calculateTotal() {
        var totalMoneyOff = 0.0
        for (entry in specialOffersApplied.entries) {
            totalMoneyOff += entry.value.toDouble()
        }
        total = BigDecimal.valueOf(subTotal.toDouble() - totalMoneyOff)
    }

    override fun calculateSubTotal() {
        val items = basketOfItems.getBasketItems()
        var subtotal = 0.0
        for (entry in items.entries){
            subtotal += entry.key.price.toDouble() * entry.value
        }
        subTotal = BigDecimal.valueOf(subtotal)
    }

    override fun applySpecialOffers() {
        val specialOffersInStore : MutableList<SpecialOfferK> = PriceBasketApplicationStoreK.getStoreSpecialOffers()

        for (item in basketOfItems.getBasketItems().keys) {
            for (specialOffer in specialOffersInStore) {
                if (specialOffer.getItemOnSpecialOffer().javaClass.isInstance(item)) {
                    if (specialOffer is SpecialOfferDiscountK) {
                        specialOffer.handleSpecialOffer(specialOffersApplied)
                    } else if (specialOffer is SpecialOfferBuy2Get1HalfPriceK) {
                        specialOffer.handleSpecialOffer(specialOffersApplied, basketOfItems, item)
                    }
                }
            }
        }
    }

    override fun generateReceipt(): ReceiptK {
        return ReceiptK(items = ArrayList(),
                specialOffersApplied = specialOffersApplied,
                subtotal = subTotal,
                total = total)
    }
}