package com.example.bmicalculator

import kotlin.math.pow

class BMICalculate {
    class BMICalculate(private val weight: Double, private val height:Double, private val gender:String) {

        private var tmp_result: BMIType = BMIType.NORMAL;
        private var bmi: Double = 0.0

        fun getResult(): Pair<Double, BMIType> {
            bmi = calculateBMI() // Calculate BMI


            // Determine the BMI category
            tmp_result = when (gender) {
                "Male" -> {
                    if (bmi < 20.7) BMIType.UNDERWEIGHT
                    else if (bmi in 20.7..26.4) BMIType.NORMAL
                    else if (bmi in 26.5..31.1) BMIType.OVERWEIGHT
                    else BMIType.OBESE
                }
                "Female" -> {
                    if (bmi < 19.1) BMIType.UNDERWEIGHT
                    else if (bmi in 19.1..25.8) BMIType.NORMAL
                    else if (bmi in 25.9..32.3) BMIType.OVERWEIGHT
                    else BMIType.OBESE
                }
                else -> BMIType.NORMAL // Handle unknown gender as normal
            }


            return Pair(bmi, tmp_result)
        }

        private fun calculateBMI(): Double {
            // BMI = weight (kg) / (height (m) * height (m))
            val heightInMeters = height / 100.0 // Convert height from cm to meters
            val heightSquared = heightInMeters.pow(2.0)

            return (weight / heightSquared);
        }
    }
}