package com.pierrepiron.blackjacknight.Model

class Hand(var card: MutableList<Card>) {
    fun getTotalCardHand(): Int {
        var total: Int = 0
        var nbCard = if(card.size > 2) card.size else 1
        for (i in 0..nbCard) {
            total += card.get(i).value
        }
        return total
    }
    fun isBust(): Boolean {
        return if(this.getTotalCardHand() > 21) true else false
    }
}