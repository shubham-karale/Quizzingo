package com.example.quizzingoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ScoreActivitty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_activitty)
//        Getting the intent and its passing the data
        val intent = intent
        val score = intent.getIntExtra("SCORE", 0)
        val scoreText = findViewById<TextView>(R.id.scoreText).setText("Your Score is : ${score} ")




    }
}