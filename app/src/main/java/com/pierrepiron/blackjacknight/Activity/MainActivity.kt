package com.pierrepiron.blackjacknight.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pierrepiron.blackjacknight.Model.Dealer
import com.pierrepiron.blackjacknight.Model.Deck
import com.pierrepiron.blackjacknight.Model.Hand
import com.pierrepiron.blackjacknight.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newGameButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}
