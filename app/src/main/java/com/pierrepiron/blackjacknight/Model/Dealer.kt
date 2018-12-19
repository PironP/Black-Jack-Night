package com.pierrepiron.blackjacknight.Model

import android.util.Log

class Dealer(var deck: MutableList<Card>) {
    fun distribCard(nbCard: Int): MutableList<Card> {
        var tabCar = mutableListOf<Card>()
        for(i in 1..nbCard) {
            tabCar.addAll(listOf(deck.get(i)))
        }
        return tabCar
    }

}