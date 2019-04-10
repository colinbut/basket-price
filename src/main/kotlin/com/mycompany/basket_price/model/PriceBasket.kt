/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

class PriceBasketK() {

    private var basketItems : MutableMap<BasketItemK, Int>? = null

    init {
        basketItems = HashMap()
    }

    fun putItemInBasket(newItemK: BasketItemK) {
        for (item in basketItems!!.keys) {
            if (item.getItemName() == newItemK.getItemName()) {
                basketItems!![item] = basketItems!!.get(item)!!.toInt() + 1
                return
            }
        }
        basketItems!![newItemK] = 1
    }

    fun getBasketItems() : Map<BasketItemK, Int> {
        return basketItems!!
    }

    fun basketContainItem(item: BasketItemK) : Boolean {
        return basketItems!!.filterKeys { it.getItemName() == item.getItemName() }.isNotEmpty()
    }
}