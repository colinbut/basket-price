/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import java.math.BigDecimal

class BasketItemStoreFactoryK {

    fun getBasketItem(itemType: ItemType) : PriceBasketItemK {
        return when(itemType) {
            ItemType.APPLE -> PriceBasketItemK("Apples", BigDecimal.valueOf(1.0))
            ItemType.BREAD -> PriceBasketItemK("Bread", BigDecimal.valueOf(1.0))
            ItemType.SOUP -> PriceBasketItemK("Soup", BigDecimal.valueOf(1.0))
            ItemType.MILK -> PriceBasketItemK("Milk", BigDecimal.valueOf(1.0))
        }
    }
}