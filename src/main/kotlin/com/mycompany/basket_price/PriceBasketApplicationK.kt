/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price

import com.mycompany.basket_price.exception.UnknownItemExceptionK
import com.mycompany.basket_price.io.PriceBasketApplicationInputReaderK
import com.mycompany.basket_price.logic.PriceBasketCheckoutK
import com.mycompany.basket_price.service.PriceBasketServiceImplK

class PriceBasketApplicationK {

    fun process(args: Array<String>) : String {
        try {
            val basket = PriceBasketApplicationInputReaderK.readInputFromCommandLine(args)
            val checkout = PriceBasketCheckoutK(basket)
            val priceBasketService = PriceBasketServiceImplK(checkout)
            return priceBasketService.getPriceOfBasketItems()
        } catch (ex : UnknownItemExceptionK) {
            println("Unknown Item in store")
            throw RuntimeException()
        }
    }

}

fun main(args: Array<String>){
    println(PriceBasketApplicationK().process(args))
}
