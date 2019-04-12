/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price

import com.mycompany.basket_price.model.ReceiptK

abstract class CheckoutK {
    abstract fun calculateTotal()
    abstract fun calculateSubTotal()
    abstract fun applySpecialOffers()
    abstract fun generateReceipt() : ReceiptK

    fun checkout() : CheckoutK {
        calculateSubTotal()
        applySpecialOffers()
        calculateTotal()
        return this
    }
}