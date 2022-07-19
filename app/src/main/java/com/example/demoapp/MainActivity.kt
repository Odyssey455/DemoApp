package com.example.demoapp

import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*

class MainActivity : AppCompatActivity() {
    //Declaring Variables to be Attached
    lateinit var diceImg: ImageView
    lateinit var numberText: TextView
    lateinit var editPlayerName: EditText
    lateinit var playerName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Attach variables via ID
        numberText = findViewById(R.id.numberText)
        diceImg = findViewById(R.id.diceImg)
        editPlayerName = findViewById(R.id.editPlayerName)
        playerName = findViewById(R.id.playerName)

        //Setting up On Click Listener
        val rollButton: Button = findViewById(R.id.rollButton)
        rollButton.setOnClickListener{ rollDice()}
        val updateButton = findViewById<Button>(R.id.updatePlayerNameBtn)
        updateButton.setOnClickListener{updatePlayerName(it)}
    }

    private fun rollDice(){
        val randomNumb = (1..6).random()
        //val numberText: TextView = findViewById(R.id.numberText)
        //val diceImg:ImageView = findViewById(R.id.diceImg)
        numberText.text = randomNumb.toString()

        val imgSrc = when (randomNumb){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImg.setImageResource(imgSrc)

        Toast.makeText(this,randomNumb.toString(),
            Toast.LENGTH_SHORT).show()
    }

    private fun updatePlayerName(view: View){
        playerName.text = editPlayerName.text

        //Hide Keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}