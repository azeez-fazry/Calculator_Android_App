package com.example.myfirstcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNumberEvent(view:View){

        // Clear the screen for new operand
        if(isNewOperand){
            etDisplay.setText("")
        }
        isNewOperand = false

        val buSelect = view as Button
        var buClickValue : String = etDisplay.text.toString()
        when(buSelect.id){

            bu0.id -> {
                buClickValue += "0"
            }
            bu1.id -> {
                buClickValue += "1"
            }
            bu2.id -> {
                buClickValue += "2"
            }
            bu3.id -> {
                buClickValue += "3"
            }
            bu4.id -> {
                buClickValue += "4"
            }
            bu5.id -> {
                buClickValue += "5"
            }
            bu6.id -> {
                buClickValue += "6"
            }
            bu7.id -> {
                buClickValue += "7"
            }
            bu8.id -> {
                buClickValue += "8"
            }
            bu9.id -> {
                buClickValue += "9"
            }
            buDot.id -> {
                //TODO: Prevent adding from one dot
                buClickValue += "."
            }

        }
        etDisplay.setText(buClickValue)

    }

    var operator = "*"
    var oldNumber = ""
    var isNewOperand = true
    fun buOperatorEvent(view:View){
        val buSelect = view as Button
        when(buSelect.id){

            buMul.id -> {
                operator = "*"
            }
            buDiv.id -> {
                operator = "/"
            }
            buSub.id -> {
                operator = "-"
            }
            buAdd.id -> {
                operator = "+"
            }

        }
        oldNumber = etDisplay.text.toString()
        isNewOperand = true
    }

    fun buEqualEvent(view:View){
        var newNumber = etDisplay.text.toString()
        var finalNumber : Double? = null
        when(operator){
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }

        }
        etDisplay.setText(finalNumber.toString())
        isNewOperand = true
    }

    fun buPercentage(view : View){
        val num : Double = etDisplay.text.toString().toDouble() / 100
        etDisplay.setText(num.toString())
        isNewOperand = true
    }

    fun buClean(view : View){
        etDisplay.setText("")
        isNewOperand = true
    }
}