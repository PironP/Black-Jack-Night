package com.pierrepiron.blackjacknight.Model

class Hand(var cards: MutableList<Card>) {
    fun getTotalCardHand(): Int {
        var total = 0
        cards.forEach { total += it.value}
        if (total > 21 && hasAce()) {
            total -= 10
        }
         return total
    }
    fun isBust(): Boolean {
        return this.getTotalCardHand() > 21
    }
    fun hasAce(): Boolean {
        var hasAce = false
        cards.forEach { card ->
            if (card.value == 11) {
                hasAce = true
            }
        }
        return hasAce
    }
}