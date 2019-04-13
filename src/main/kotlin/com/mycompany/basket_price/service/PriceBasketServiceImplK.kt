/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.service

import com.mycompany.basket_price.PriceBasketCheckoutK
import com.mycompany.basket_price.io.PriceBasketApplicationOutputWriterK
import com.mycompany.basket_price.model.ReceiptK

class PriceBasketServiceImplK(private val checkoutTill: PriceBasketCheckoutK) : PriceBasketServiceK {

    override fun getPriceOfBasketItems(): String {
        val receipt : ReceiptK = checkoutTill.checkout().generateReceipt()
        return PriceBasketApplicationOutputWriterK.writeOutput(receipt)
    }

}