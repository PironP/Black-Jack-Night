package com.pierrepiron.blackjacknight.Model

import android.util.Log
import java.util.*

class Dealer(deck: Deck) {
    fun distribCard(nbCard: Int): MutableList<Card> {
        var deck = Deck().createPack()
        var tabCar = mutableListOf<Card>()
        deck.shuffle()
        for(i in 1..nbCard) {
            tabCar.addAll(listOf(deck.get(i)))
        }
        return tabCar
    }

}