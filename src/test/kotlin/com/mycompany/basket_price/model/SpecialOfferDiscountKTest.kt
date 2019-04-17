/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class SpecialOfferDiscountKTest {

    private val specialOfferDiscount : SpecialOfferDiscountK
            = SpecialOfferDiscountK(50.0, PriceBasketItemK("Apples", BigDecimal.valueOf(2.00)))

    @Test
    fun `test handle special offer discount` () {
        var specialOffersApplied : MutableMap<SpecialOfferK, BigDecimal> = HashMap()

        specialOffersApplied = specialOfferDiscount.handleSpecialOffer(specialOffersApplied) as MutableMap<SpecialOfferK, BigDecimal>

        assertEquals(BigDecimal.valueOf(0.5), specialOffersApplied[specialOfferDiscount])
    }
}