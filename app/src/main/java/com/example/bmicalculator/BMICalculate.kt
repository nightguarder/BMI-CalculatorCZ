package com.example.bmicalculator

import kotlin.math.pow

class BMICalculate {
    class BMICalculate(private val weight: Double, private val height:Double) {

        private var tmp_result: BMIType = BMIType.NORMAL;
        private var bmi: Double = 0.0

        fun getResult(): Pair<Double, BMIType> {
            bmi = calculateBMI() // Calculate BMI

            // Determine the BMI category
            tmp_result = if (bmi < 18.5) {
                BMIType.UNDERWEIGHT
            } else if (bmi in 18.5..24.9) {
                BMIType.NORMAL
            } else if (bmi in 25.0..29.9) {
                BMIType.OVERWEIGHT
            } else {
                BMIType.OBESE
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