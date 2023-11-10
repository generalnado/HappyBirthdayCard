package com.example.happybirthdaycard
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar


@Suppress("NAME_SHADOWING")
//This is my first upload to Github
//Learning to connect to github
//Updating with new knowledge
//new update
//once more
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userDOB = findViewById<TextView>(R.id.userDOB)
        userDOB.setOnClickListener {
            printAge()

        }
    }

    @SuppressLint("SetTextI18n")
    private fun printAge() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, year, month, day ->

            val selectedDate = "$day/${month + 1}/$year"

            val userDOB = findViewById<TextView>(R.id.userDOB)
            userDOB.text = selectedDate


            val dob = Calendar.getInstance()
            dob.set(year, month, day)

            var age = myCalendar.get(Calendar.YEAR) - dob.get(Calendar.YEAR)
            if (myCalendar.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
                age--
            }
            val userAge = findViewById<TextView>(R.id.userAge)
            userAge.text = "You are $age years old."


            val birthStone = findViewById<ImageView>(R.id.birthStone)
            when (dob.get(Calendar.MONTH)) {
                1 -> birthStone.setImageResource(R.drawable.feb)
                2 -> birthStone.setImageResource(R.drawable.mar)
                3 -> birthStone.setImageResource(R.drawable.apr)
                4 -> birthStone.setImageResource(R.drawable.may)
                5 -> birthStone.setImageResource(R.drawable.jun)
                6 -> birthStone.setImageResource(R.drawable.jul)
                7 -> birthStone.setImageResource(R.drawable.aug)
                8 -> birthStone.setImageResource(R.drawable.sep)
                9 -> birthStone.setImageResource(R.drawable.oct)
                10 -> birthStone.setImageResource(R.drawable.nov)
                11 -> birthStone.setImageResource(R.drawable.dec)
                12 -> birthStone.setImageResource(R.drawable.jan)
            }
            val result = 2060 - dob.get(Calendar.YEAR)
            val finalResult = result%12
            val zodiac = findViewById<ImageView>(R.id.zodiac)
            when (finalResult) {
                    0 -> zodiac.setImageResource(R.drawable.dragon)
                    1 -> zodiac.setImageResource(R.drawable.rabbit)
                    2 -> zodiac.setImageResource(R.drawable.tiger)
                    3 -> zodiac.setImageResource(R.drawable.ox)
                    4 -> zodiac.setImageResource(R.drawable.rat)
                    5 -> zodiac.setImageResource(R.drawable.pig)
                    6 -> zodiac.setImageResource(R.drawable.dog)
                    7 -> zodiac.setImageResource(R.drawable.rooster)
                    8 -> zodiac.setImageResource(R.drawable.monkey)
                    9 -> zodiac.setImageResource(R.drawable.goat)
                    10 -> zodiac.setImageResource(R.drawable.horse)
                    else -> zodiac.setImageResource(R.drawable.snake)

            }
                               }, year, month, day).show()

    }

    fun goTo(view: View) {
        val userName = findViewById<EditText>(R.id.userName)
        val name = userName.editableText.toString()
        val intent = Intent(this, Greetings::class.java)
        intent.putExtra("name", name)
        startActivity(intent)

        }


        }
