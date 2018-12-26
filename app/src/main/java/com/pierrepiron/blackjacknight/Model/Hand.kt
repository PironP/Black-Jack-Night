package com.pierrepiron.blackjacknight.Model

class Hand(var cards: MutableList<Card>) {
    fun getTotalCardHand(): Int {
        var total: Int = 0
        var nbCard = if(cards.size > 2) cards.size else 1
        for (i in 0..nbCard) {
            total += cards.get(i).value
        }
        return total
    }
    fun isBust(): Boolean {
        return if(this.getTotalCardHand() > 21) true else false
    }
}