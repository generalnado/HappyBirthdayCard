package com.example.happybirthdaycard

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Greetings : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greetings)
        val name = intent.getStringExtra("name")
        //val age = intent.getStringExtra("age")
        val greetings = findViewById<TextView>(R.id.greetings)
        greetings.text = "Happy Birthday $name!"

    }
}