package com.pierrepiron.blackjacknight.Model

import android.util.Log
import java.util.*

class Deck {
    fun createPack(): MutableList<Card>{
        val suits = listOf("Spade", "Club", "Heart", "Diamond")
        var arrayCard = mutableListOf<Card>()

        for (suit: String in suits) {
            for(i in 1..13) {
                arrayCard.addAll(listOf(Card(i.toString(), suit, this.valueOfCard(i))))
            }
        }
        arrayCard.shuffle()
        return arrayCard
    }

    fun valueOfCard(i: Int) = if(i >= 10) 10 else i
}