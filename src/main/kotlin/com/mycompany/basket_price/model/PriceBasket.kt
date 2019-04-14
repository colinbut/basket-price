/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

class PriceBasketK {

    private var basketItems : MutableMap<PriceBasketItemK, Int>? = null

    init {
        basketItems = HashMap()
    }

    fun putItemInBasket(newItemK: PriceBasketItemK) {
        for (item in basketItems!!.keys) {
            if (item.name == newItemK.name) {
                basketItems!![item] = basketItems!!.get(item)!!.toInt() + 1
                return
            }
        }
        basketItems!![newItemK] = 1
    }

    fun getBasketItems() : Map<PriceBasketItemK, Int> {
        return basketItems!!
    }

    fun basketContainItem(item: PriceBasketItemK) : Boolean {
        return basketItems!!.filterKeys { it.name == item.name }.isNotEmpty()
    }
}