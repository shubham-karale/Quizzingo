package com.example.quizzingoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed
import com.example.quizzingoapp.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        Adding the Handler for shifting the screen
        Handler(Looper.getMainLooper()).postDelayed(3000) {
            if (Firebase.auth.currentUser != null) {
                val intent = Intent(this, QuizActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("MODE", "SignUp")
                startActivity(intent)
            }


        }
    }


}