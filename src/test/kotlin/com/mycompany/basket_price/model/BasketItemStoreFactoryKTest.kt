/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

import kotlin.test.Test
import kotlin.test.assertTrue

class BasketItemStoreFactoryKTest {

    private val storeFactoryK : BasketItemStoreFactoryK = BasketItemStoreFactoryK()

    @Test
    fun `test get basket items` () {
        val apple = storeFactoryK.getBasketItem(ItemType.APPLE)
        assertTrue { apple.name == "Apples" }

        val milk = storeFactoryK.getBasketItem(ItemType.MILK)
        assertTrue { milk.name == "Milk" }

        val soup = storeFactoryK.getBasketItem(ItemType.SOUP)
        assertTrue { soup.name == "Soup" }

        val bread = storeFactoryK.getBasketItem(ItemType.BREAD)
        assertTrue { bread.name == "Bread" }
    }
}