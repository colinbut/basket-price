/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.math.BigDecimal

interface BasketItemK {
    fun getItemName() : String
    fun setItemName(name: String)
    fun getItemPrice() : BigDecimal
    fun setItemPrice(price: BigDecimal)
}