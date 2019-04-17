/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertTrue

class PriceBasketKTest {

    private val priceBasket : PriceBasketK = PriceBasketK()

    @Test
    fun `test put item in basket` () {
        val apples = PriceBasketItemK("Apples", BigDecimal.valueOf(0.80))

        priceBasket.putItemInBasket(apples)

        assertTrue { priceBasket.getBasketItems().containsKey(apples) }

        priceBasket.putItemInBasket(apples)
        assertTrue { priceBasket.getBasketItems().size == 1 }
    }

    @Test
    fun `test basket contain item` () {
        val bread = PriceBasketItemK("Bread", BigDecimal.valueOf(1.20))

        priceBasket.putItemInBasket(bread)
        priceBasket.putItemInBasket(bread)
        priceBasket.putItemInBasket(bread)

        assertTrue { priceBasket.basketContainItem(bread) }
    }
}