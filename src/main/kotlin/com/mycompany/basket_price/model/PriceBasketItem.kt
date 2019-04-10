/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.math.BigDecimal

data class PriceBasketItemK(private var name: String, var price: BigDecimal) : BasketItemK {

    override fun getItemName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setItemName(name: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemPrice(): BigDecimal {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setItemPrice(price: BigDecimal) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}