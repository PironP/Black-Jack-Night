package com.pierrepiron.blackjacknight.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        drawButton.setOnClickListener { drawButtonPressed() }
        stopButton.setOnClickListener { playersTurnEnd() }
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

        showPlayerScore()
        showPlayerCard()
        playersTurn()
    }

    fun playersTurn() {
        if (player.hand.cards.count() == 4 || player.hand.getTotalCardHand() >= 21) {
            // dealer's turn
            playersTurnEnd()
        } else {
            drawButton.visibility = Button.VISIBLE
            stopButton.visibility = Button.VISIBLE
        }
    }

    fun playersTurnEnd() {
        drawButton.visibility = Button.GONE
        stopButton.visibility = Button.GONE
        dealerCard2.setImageResource(getCardDrawable(dealer.hand.cards[1]))
        dealersTurn()
    }

    fun dealersTurn() {
        if (
            dealer.hand.getTotalCardHand() >= player.hand.getTotalCardHand()
            || dealer.hand.cards.count() == 4
            || player.hand.isBust()
            || dealer.hand.isBust()
        ) {
            // End Round
        } else if (dealer.hand.cards.count() == 2) {
            dealer.hand.cards.add(dealer.distribCard())
            showDealerValue()
            dealerCard3.setImageResource(getCardDrawable(dealer.hand.cards[2]))
            dealerCard3.visibility = ImageView.VISIBLE
            dealersTurn()
        } else {
            dealer.hand.cards.add(dealer.distribCard())
            showDealerValue()
            dealerCard4.setImageResource(getCardDrawable(dealer.hand.cards[3]))
            dealerCard4.visibility = ImageView.VISIBLE
            dealersTurn()
        }
    }

    fun drawButtonPressed() {
        player.hand.cards.add(dealer.distribCard())
        showPlayerScore()
        if (player.hand.cards.count() == 3) {
            playerCard3.setImageResource(getCardDrawable(player.hand.cards[2]))
            playerCard3.visibility = ImageView.VISIBLE
        } else {
            playerCard4.setImageResource(getCardDrawable(player.hand.cards[3]))
            playerCard4.visibility = ImageView.VISIBLE
        }
        playersTurn()
    }

    fun showPlayerScore() {
        playerValue.text = "Value: " + player.hand.getTotalCardHand().toString()
    }

    fun showPlayerCard() {
        playerCard1.setImageResource(getCardDrawable(player.hand.cards[0]))
        playerCard2.setImageResource(getCardDrawable(player.hand.cards[1]))
        dealerCard1.setImageResource(getCardDrawable(dealer.hand.cards[0]))
    }

    fun showDealerValue() {
        dealerValue.text = "Value: " + dealer.hand.getTotalCardHand().toString()
    }

    fun getCardDrawable(card: Card): Int {
        val cardValue: String
        when (card.name) {
            "1" -> cardValue = "a"
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

        drawButton.visibility = Button.GONE
        stopButton.visibility = Button.GONE

        player.hand.cards.clear()
        dealer.hand.cards.clear()
    }
}
