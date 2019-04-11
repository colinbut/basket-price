/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.basket_price.model

object PriceBasketApplicationStoreK {

    private val storeFactoryK : BasketItemStoreFactoryK = BasketItemStoreFactoryK()

    private val specialOffersInStore : ArrayList<SpecialOfferK> = ArrayList()

    init {
        configureSpecialOffersInStoreIntoSystem()
    }

    private fun configureSpecialOffersInStoreIntoSystem() {

    }

}