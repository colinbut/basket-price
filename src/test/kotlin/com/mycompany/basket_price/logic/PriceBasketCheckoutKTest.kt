/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.logic

import com.mycompany.basket_price.model.PriceBasketItemK
import com.mycompany.basket_price.model.PriceBasketK
import org.mockito.Mock
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class PriceBasketCheckoutKTest {

    @Mock
    private var basketOfItems : PriceBasketK = PriceBasketK()

    private val priceBasketCheckoutK : PriceBasketCheckoutK = PriceBasketCheckoutK(basketOfItems)

    @Test
    fun `test calculate subtotal before any deductions of any special offers applied` () {
        val data : MutableMap<PriceBasketItemK, Int> = HashMap()
        data[PriceBasketItemK("Apples", BigDecimal.valueOf(1.00))] = 1
        data[PriceBasketItemK("Apples", BigDecimal.valueOf(1.00))] = 1
        data[PriceBasketItemK("Soup", BigDecimal.valueOf(0.65))] = 2
        data[PriceBasketItemK("Milk", BigDecimal.valueOf(1.30))] = 1
        data[PriceBasketItemK("Bread", BigDecimal.valueOf(0.80))] = 3

        priceBasketCheckoutK.calculateSubTotal()

        assertEquals(BigDecimal.valueOf(7.00), priceBasketCheckoutK.subTotal)
    }
}