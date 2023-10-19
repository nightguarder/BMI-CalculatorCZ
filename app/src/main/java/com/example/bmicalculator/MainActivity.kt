package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Define variables
        val weight_str: EditText = findViewById(R.id.vaha_input)
        val vyska_str: EditText = findViewById(R.id.vyska_input)
        val pohlavi_group: RadioGroup = findViewById(R.id.radioGroupGender)
        var pohlavi_default: String = "Male"
        val calculate_btn: Button = findViewById(R.id.buttonCalculate)
        val clear_btn: Button = findViewById(R.id.buttonClear)
        val result_txt: TextView = findViewById(R.id.vysledek_output)

        // Listen to Gender
        pohlavi_group.setOnCheckedChangeListener { group, checkedId ->
            pohlavi_default = when (checkedId) {
                R.id.radioButtonMen -> "Male"
                R.id.radioButtonWomen -> "Female"
                else -> "Male" // Default to "Men" if none selected
            }
        }
        //Listen to Calculate
        calculate_btn.setOnClickListener {
            val weightText = weight_str.text.toString()
            val heightText = vyska_str.text.toString()

            // Check if both input fields are not empty
            if (weightText.isNotEmpty() && heightText.isNotEmpty()) {
                // Convert input to numeric values
                val weight = weightText.toDouble()
                val height = heightText.toDouble()

                // Calculate BMI //Weight:Double, Height:Double, and Category
                val func_value = BMICalculate.BMICalculate(weight,height,pohlavi_default)
                val (bmi,category) = func_value.getResult()

                // Display the result in the TextView
                result_txt.text = "Vaše BMI: ${"%.1f".format(bmi)} Kategorie: ${category.text}"
            }
            else {
                // Handle case where one or both fields are empty
                result_txt.text = "Prosím zadejte Výšku a Váhu."
            }

        }
        //Listen to Clear
        clear_btn.setOnClickListener{
            weight_str.text.clear()
            vyska_str.text.clear()
            result_txt.text = ""
        }
    }
}