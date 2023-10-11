package com.example.quizzingoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.quizzingoapp.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class QuizActivity : AppCompatActivity() {
    //    val binding : ActivityMainBinding by lazy {
//        ActivityMainBinding.inflate(layoutInflater)
//    }
    private var count: Int = 0
    private var score: Int = 0
    lateinit var list: ArrayList<QuestionModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        list = ArrayList<QuestionModel>()

        Firebase.firestore.collection("Quiz").get().addOnSuccessListener {
            for (i in it) {
                list.add(
                    QuestionModel(
                        i.getString("question").toString(),
                        i.getString("option1").toString(),
                        i.getString("option2").toString(),
                        i.getString("option3").toString(),
                        i.getString("option4").toString(),
                        i.getString("ans").toString()
                    )
                )
            }
            var question = findViewById<TextView>(R.id.question)
            var option1 = findViewById<Button>(R.id.option1)
            var option2 = findViewById<Button>(R.id.option2)
            var option3 = findViewById<Button>(R.id.option3)
            var option4 = findViewById<Button>(R.id.option4)
            question.setText(list[count].question)
            option1.setText(list[count].opton1)
            option2.setText(list[count].option2)
            option3.setText(list[count].option3)
            option4.setText(list[count].option4)
        }.addOnFailureListener {
            Toast.makeText(this, "Error in Fetching Data", Toast.LENGTH_LONG).show()
        }

        list.add(
            QuestionModel(
                "What is the capital of India?",
                "Delhi",
                "Mumbai",
                "Kolkata",
                "Chennai",
                "Delhi"
            )
        )
        list.add(
            QuestionModel(
                "Who is the Owner Of Amazon",
                "Bill Gates",
                "Jeff Bezos",
                "Warren Buffet",
                "Elon Musk",
                "Jeff Bezos"
            )
        )

        list.add(
            QuestionModel(
                "Who is the Owner Of Microsoft",
                "Bill Gates",
                "Jeff Bezos",
                "Warren Buffet",
                "Elon Musk",
                "Bill Gates"
            )
        )

        list.add(
            QuestionModel(
                "Who is the Owner Of Tesla",
                "Bill Gates",
                "Jeff Bezos",
                "Warren Buffet",
                "Elon Musk",
                "Elon Musk"
            )
        )

        list.add(
            QuestionModel(
                "Who is the Owner Of Facebook",
                "Bill Gates",
                "Jeff Bezos",
                "Warren Buffet",
                "Mark Zuckerberg",
                "Mark Zuckerberg"
            )
        )


        var question = findViewById<TextView>(R.id.question)
        var option1 = findViewById<Button>(R.id.option1)
        var option2 = findViewById<Button>(R.id.option2)
        var option3 = findViewById<Button>(R.id.option3)
        var option4 = findViewById<Button>(R.id.option4)




        option1.setOnClickListener {
            nextData(option1.text.toString())
        }

        option2.setOnClickListener {
            nextData(option2.text.toString())
        }

        option3.setOnClickListener {
            nextData(option3.text.toString())
        }

        option4.setOnClickListener {
            nextData(option4.text.toString())
        }


    }

    public fun nextData(i: String) {

        if (i.equals(list[count].ans)) {
            score++
        }

        count++

        if (count >= list.size) {

            Toast.makeText(this, "Your Score is $score", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ScoreActivitty::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
            finish()

        }
        else {
            var question = findViewById<TextView>(R.id.question)
            var option1 = findViewById<Button>(R.id.option1)
            var option2 = findViewById<Button>(R.id.option2)
            var option3 = findViewById<Button>(R.id.option3)
            var option4 = findViewById<Button>(R.id.option4)
            question.setText(list[count].question)
            option1.setText(list[count].opton1)
            option2.setText(list[count].option2)
            option3.setText(list[count].option3)
            option4.setText(list[count].option4)
        }

    }
}