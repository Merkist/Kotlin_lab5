package com.example.kotlinlab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class part2_calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_part2_calculator)
        //введення значень
        val inputEmer: EditText = findViewById(R.id.input_emer)
        val input2Plan: EditText = findViewById(R.id.input_plan)

        //контрольний приклад
        inputEmer.setText("23.6")
        input2Plan.setText("17.6")

        //результати обчислень
        val result: TextView = findViewById(R.id.result)

        //кнопки обчислення та повернення назад
        val backButton: Button = findViewById(R.id.button_back2)
        val sumButton: Button = findViewById(R.id.button_calculate2)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        sumButton.setOnClickListener {
            val valueEmer = inputEmer.text.toString()
            val valuePlan = input2Plan.text.toString()

            // перевірка та наявність значень
            if (valueEmer.isNotEmpty() && valuePlan.isNotEmpty()) {
                try {
                    val valueEmer_f = valueEmer.toFloat()
                    val valuePlan_f = valuePlan.toFloat()

                    val wt = 0.00001*45
                    val k = 0.004
                    val p = 5.12*1000
                    val t = 6451.0

                    val mwE = wt*p*t
                    val mwA = k*p*t

                    val mz = valueEmer_f*mwE + valuePlan_f*mwA

                    result.text = String.format(Locale.US, "%.1f", mz)


                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Введіть коректні числа.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Всі поля повинні бути заповненні.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}