package com.example.kotlinlab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class part1_calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_part1_calculator)

        //введення значень
        val input1: EditText = findViewById(R.id.input_1)
        val input2: EditText = findViewById(R.id.input_2)
        val input3: EditText = findViewById(R.id.input_3)
        val input4: EditText = findViewById(R.id.input_4)
        val input5: EditText = findViewById(R.id.input_5)
        val input6: EditText = findViewById(R.id.input_6)

        //контрольний приклад
        input1.setText("0.01")
        input2.setText("0.07")
        input3.setText("0.015")
        input4.setText("0.02")
        input5.setText("6")
        input6.setText("0.03")

        //результати обчислень
        val resultW1: TextView = findViewById(R.id.result_w1)
        val resultW12: TextView = findViewById(R.id.result_w1_2)
        val resultW2: TextView = findViewById(R.id.result_w2)

        //кнопки обчислення та повернення назад
        val backButton: Button = findViewById(R.id.button_back)
        val sumButton: Button = findViewById(R.id.button_calculate)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        sumButton.setOnClickListener {
            val value1 = input1.text.toString()
            val value2 = input2.text.toString()
            val value3 = input3.text.toString()
            val value4 = input4.text.toString()
            val value5 = input5.text.toString()
            val value6 = input6.text.toString()

            // перевірка та наявність значень
            if (value1.isNotEmpty() && value2.isNotEmpty() && value3.isNotEmpty()
                && value4.isNotEmpty() && value5.isNotEmpty() && value6.isNotEmpty()) {
                try {
                    val value1_f = value1.toFloat()
                    val value2_f = value2.toFloat()
                    val value3_f = value3.toFloat()
                    val value4_f = value4.toFloat()
                    val value5_f = value5.toFloat()
                    val value6_f = value6.toFloat()

                    val woc = value1_f+value2_f+value3_f+value4_f+value5_f*value6_f
                    val tvoc = (value1_f*30+value2_f*10+value3_f*100+value4_f*15+value5_f*value6_f*2)/woc
                    val kaoc = (woc*tvoc)/8760
                    val kpoc = 1.2 * (43.0/8760)

                    val wdk = 2*woc*(kaoc+kpoc)
                    val wdc = wdk + 0.02

                    resultW1.text = String.format(Locale.US, "%.4f", woc)
                    resultW12.text = String.format(Locale.US, "%.4f", wdk)
                    resultW2.text = String.format(Locale.US, "%.4f", wdc)


                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Введіть коректні числа.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Всі поля повинні бути заповненні.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}