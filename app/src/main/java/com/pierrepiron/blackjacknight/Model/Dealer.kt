package com.pierrepiron.blackjacknight.Model

import android.util.Log

class Dealer(var deck: MutableList<Card>, var hand: Hand) {
    fun distribCards(nbCard: Int): MutableList<Card> {
        var tabCar = mutableListOf<Card>()
        for(i in 1..nbCard) {
            tabCar.addAll(listOf(deck.get(i)))
            deck.removeAt(i)
        }
        return tabCar
    }

    fun distribCard(): Card {
        val card = deck.get(0)
        deck.removeAt(0)
        return card
    }


}