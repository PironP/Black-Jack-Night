package com.pierrepiron.blackjacknight.Model

class Hand(var cards: MutableList<Card>) {
    fun getTotalCardHand(): Int {
        var total: Int = 0
        cards.forEach { total += it.value}
         return total
    }
    fun isBust(): Boolean {
        return if(this.getTotalCardHand() > 21) true else false
    }
}