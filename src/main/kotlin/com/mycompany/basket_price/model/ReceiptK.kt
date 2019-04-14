package com.mycompany.basket_price.model

import java.math.BigDecimal

class ReceiptK (val items: MutableList<PriceBasketItemK>,
                val specialOffersApplied: MutableMap<SpecialOfferK, BigDecimal>,
                val subtotal: BigDecimal,
                val total: BigDecimal)
