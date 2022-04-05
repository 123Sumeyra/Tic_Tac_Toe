package com.sum.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.sum.tic_tac_toe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    var player1 = 0
    var player2 = 1
    var activePlayer = player1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button1.setOnClickListener(this)
        binding.button2.setOnClickListener(this)
        binding.button3.setOnClickListener(this)
        binding.button4.setOnClickListener(this)
        binding.button5.setOnClickListener(this)
        binding.button6.setOnClickListener(this)
        binding.button7.setOnClickListener(this)
        binding.button8.setOnClickListener(this)
        binding.button9.setOnClickListener(this)



    }

    override fun onClick(view: View?) {
        var btnClicked = findViewById<Button>(view!!.id) // btnClicked = button should be

        //btnClicked.setText("X")
        if (activePlayer == player1) {
            btnClicked.text = "X"
            btnClicked.isClickable = false
            activePlayer = player2
            btnClicked.setBackgroundColor(Color.CYAN)
            binding.textViewTurn.text = "Player2 Turn"




        } else {
            btnClicked.text = "O"
            btnClicked.isClickable = false

            activePlayer = player1
            btnClicked.setBackgroundColor(Color.RED)

            binding.textViewTurn.text = "Player1 Turn"
        }
        if (checkForVictory()){
            binding.textViewTurn.text=  "Winner is $activePlayer"
            disableButton()

        }


    }

    private fun checkForVictory():Boolean{

        val btn1 =binding.button1.text.toString()
        val btn2 =binding.button2.text.toString()
        val btn3 =binding.button3.text.toString()
        val btn4 =binding.button4.text.toString()
        val btn5 =binding.button5.text.toString()
        val btn6 =binding.button6.text.toString()
        val btn7 =binding.button7.text.toString()
        val btn8 =binding.button8.text.toString()
        val btn9 =binding.button9.text.toString()



        //Horizontal Victory
       if( (btn1== "X"  && btn2 == "X" && btn3 =="X") || (btn1== "O"  && btn2 == "O" && btn3 =="O")){


           return true

       }
        if((btn4 == "X"  && btn5 =="X" && btn6 =="X") || (btn4 == "O"  && btn5 =="O" && btn6 =="O")){

            return true

        }
        if((btn7 == "X" && btn8 =="X"  &&  btn9 == "X") || (btn7 == "O" && btn8 =="O"  &&  btn9 == "O")){

            return true

        }


        //Vertical Victory
        if((btn1 == "X"  && btn4 =="X"  &&  btn7 =="X")||(btn1 == "O"  && btn4 =="O"  &&  btn7 =="O ")){

            return true

        }
        if((btn2 =="X" && btn5== "X"  && btn8 == "X") ||(btn2 =="O" && btn5== "O"  && btn8 == "O")){

            return true

        }
        if((btn3 == "X" && btn6 =="X"  && btn9 =="X")||(btn3 == "O" && btn6 =="O"  && btn9 =="O")){

            return true

        }

        //Diagonal Victory
        if((btn1 =="X" &&  btn5 =="X"  &&  btn9=="X")||(btn1 =="O" &&  btn5 =="O"  &&  btn9=="O")){

            return true

        }
        if((btn3 =="X" && btn5=="X"  && btn7 == "X")||(btn3 =="O" && btn5=="O"  && btn7 == "O")){

            return true

        }

        return false

    }

    fun disableButton(){
        binding.button1.isEnabled = false
        binding.button2.isEnabled = false
        binding.button3.isEnabled = false
        binding.button4.isEnabled = false
        binding.button5.isEnabled = false
        binding.button6.isEnabled = false
        binding.button7.isEnabled = false
        binding.button8.isEnabled = false
        binding.button9.isEnabled = false

    }


}