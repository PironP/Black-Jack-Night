package com.pierrepiron.blackjacknight.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pierrepiron.blackjacknight.Model.Dealer
import com.pierrepiron.blackjacknight.Model.Deck
import com.pierrepiron.blackjacknight.Model.Hand
import com.pierrepiron.blackjacknight.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deck = Deck().createPack()
        val dealer = Dealer(deck)
        val distrib = dealer.distribCard(2)
        Log.e("Debug1", "Card1 : " + distrib)
        val valueHand = Hand(distrib).isBust()
        Log.e("Debug2", "Card2 : " + valueHand)
    }
}
