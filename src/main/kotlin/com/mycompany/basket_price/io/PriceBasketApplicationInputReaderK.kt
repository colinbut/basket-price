/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.io

import com.mycompany.basket_price.model.ItemType
import com.mycompany.basket_price.model.PriceBasketApplicationStoreK
import com.mycompany.basket_price.model.PriceBasketK

object PriceBasketApplicationInputReaderK {

    fun readInputFromCommandLine(args: Array<String>) : PriceBasketK {
        val basket = PriceBasketK()

        for (item in args) {
            basket.putItemInBasket(PriceBasketApplicationStoreK
                    .storeFactory()
                    .getBasketItem(ItemType.valueOf(item)))
        }
        return basket
    }
}