package com.pierrepiron.blackjacknight.Model

import android.util.Log
import java.util.*

class Deck {
    fun createPack(): Array<Card>{
        val suits = listOf("Spade", "Club", "Heart", "Diamond")
        var carCode: Int = 1
        var arrayCard = arrayOf<Card>()

        for (suit: String in suits) {
            for(i in 1..14) {
                arrayCard += Card(i.toString(), suit, this.valueOfCard(i))
                carCode++
            }
        }
        Log.d("Debug Deck", "Array : " + arrayCard.get(28))
        return arrayCard
    }

    fun valueOfCard(i: Int) = if(i >= 10) 10 else i
}