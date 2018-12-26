package com.pierrepiron.blackjacknight.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.pierrepiron.blackjacknight.Model.*
import com.pierrepiron.blackjacknight.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    val player: Player = Player("Player", Hand(mutableListOf()), 100)
    val dealer: Dealer = Dealer(mutableListOf(), Hand(mutableListOf()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        setupNewGame()
    }

    fun setupNewGame() {
        dealer.deck = Deck().createPack()
        startRound()
    }

    fun startRound() {
        if (dealer.deck.count() < 8) {
            dealer.deck = Deck().createPack()
        }
        refreshForNewRound()
        player.tokens -= 10
        tokenCount.text = player.tokens.toString()
        player.hand.cards = dealer.distribCards(2)
        dealer.hand.cards = dealer.distribCards(2)

        showValue("player")
        showPlayerCard()
    }

    fun showValue(character: String) {
        if (character === "player") {
            playerValue.text = "Value: " + player.hand.getTotalCardHand().toString()
        } else {
            dealerValue.text = "Value: " + dealer.hand.getTotalCardHand().toString()
        }
    }

    fun showPlayerCard() {
        playerCard1.setImageResource(getCardDrawable(player.hand.cards[0]))
        playerCard2.setImageResource(getCardDrawable(player.hand.cards[1]))
        dealerCard1.setImageResource(getCardDrawable(dealer.hand.cards[0]))
    }

    fun getCardDrawable(card: Card): Int {
        var cardValue: String
        when (card.name) {
            "14" -> cardValue = "a"
            "11" -> cardValue = "j"
            "12" -> cardValue = "q"
            "13" -> cardValue = "k"
            else -> {
                cardValue = card.name
            }
        }
        val cardName = "@drawable/card" + card.symbol.toLowerCase() + "s" + cardValue
        return this.resources.getIdentifier(cardName, null, this.packageName)
    }

    fun refreshForNewRound() {
        playerValue.text = "Value: "
        dealerValue.text = "Value: "
        val backCardId = this.resources.getIdentifier("@drawable/cardbackred", null, this.packageName)
        playerCard1.setImageResource(backCardId)
        playerCard2.setImageResource(backCardId)
        playerCard3.setImageResource(backCardId)
        playerCard4.setImageResource(backCardId)

        dealerCard1.setImageResource(backCardId)
        dealerCard2.setImageResource(backCardId)
        dealerCard3.setImageResource(backCardId)
        dealerCard4.setImageResource(backCardId)

        playerCard3.visibility = ImageView.GONE
        playerCard4.visibility = ImageView.GONE
        dealerCard3.visibility = ImageView.GONE
        dealerCard4.visibility = ImageView.GONE
    }
}
