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
        specialOffersInStore.add(SpecialOfferDiscountK(10.0, storeFactoryK.getBasketItem(ItemType.APPLE)))
        specialOffersInStore.add(SpecialOfferBuy2Get1HalfPriceK(storeFactoryK.getBasketItem(ItemType.SOUP), storeFactoryK.getBasketItem(ItemType.BREAD)))
    }

    fun getStoreSpecialOffers() : MutableList<SpecialOfferK> {
        return specialOffersInStore
    }

    fun storeFactory() : BasketItemStoreFactoryK {
        return storeFactoryK
    }

}