/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.math.BigDecimal

interface SpecialOfferK {
    fun getItemOnSpecialOffer() : BasketItemK
    fun handleSpecialOffer(vararg varargs: Any) : Map<SpecialOfferK, BigDecimal>
}