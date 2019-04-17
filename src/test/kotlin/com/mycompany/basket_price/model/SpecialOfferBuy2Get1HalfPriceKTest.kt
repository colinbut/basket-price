/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class SpecialOfferBuy2Get1HalfPriceKTest {

    private val specialOffer : SpecialOfferBuy2Get1HalfPriceK

    init {
        val bread = PriceBasketItemK("Bread", BigDecimal.valueOf(1.00))
        val soup = PriceBasketItemK("Soup", BigDecimal.valueOf(1.00))
        specialOffer = SpecialOfferBuy2Get1HalfPriceK(bread, soup)
    }

    @Test
    fun `test handle special offer` () {
        val bread = PriceBasketItemK("Bread", BigDecimal.valueOf(0.90))
        val soup = PriceBasketItemK("Soup", BigDecimal.valueOf(1.30))
        val apples = PriceBasketItemK("Apples", BigDecimal.valueOf(1.10))
        val milk = PriceBasketItemK("Milk", BigDecimal.valueOf(0.50))

        val priceBasket = PriceBasketK()
        priceBasket.putItemInBasket(bread)
        priceBasket.putItemInBasket(apples)
        priceBasket.putItemInBasket(bread)
        priceBasket.putItemInBasket(milk)
        priceBasket.putItemInBasket(soup)

        var specialOffersApplied : MutableMap<SpecialOfferK, BigDecimal> = HashMap()

        specialOffersApplied = specialOffer.handleSpecialOffer(specialOffersApplied, priceBasket, bread) as MutableMap<SpecialOfferK, BigDecimal>

        assertEquals(BigDecimal.ONE, specialOffersApplied[specialOffer])
    }
}