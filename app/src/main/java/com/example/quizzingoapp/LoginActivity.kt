package com.example.quizzingoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizzingoapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener({
            Firebase.auth.createUserWithEmailAndPassword(binding.userEmail.text.toString(),
                binding.userPassword.text.toString()).addOnCompleteListener({
                    
                    if(it.isSuccessful)
                    {
                        Toast.makeText(this,"User Created Successfully",Toast.LENGTH_LONG).show()
                    }
                else {
                        Toast.makeText(this,"User Creation Failed Please Try Again",Toast.LENGTH_LONG).show()
                    }
            })
        })
    }
}