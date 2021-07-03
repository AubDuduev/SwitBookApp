package com.example.swiftbookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Math.PI
import java.lang.Math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.basket_layout)

    val radiusCircle: Double = 5.0
    val sideSquare  : Double = 5.0
    val circleArea = this.areaOfCircleCalculator(radiusCircle)
    val squareArea = this.areaOfSquareCalculator(sideSquare)

    val comparisonResult = this.compareTheAreaOfSquareAndCircle(squareArea, circleArea)

  }
  //S = π * r2
  private fun areaOfCircleCalculator(x: Double): Double {
    val result = PI * (x * x)
    return result
  }
  //S = a2
  private fun areaOfSquareCalculator(x: Double): Double {
    val result = x * x
    return result
  }

  private fun compareTheAreaOfSquareAndCircle(square: Double, circle: Double): String {

    val result = when (true) {

      square == circle -> "Площади равны"

      square > circle -> "Площадь квадрата больше"

      square < circle -> "Площадь круга больше"

      else -> "Резултат не известен"

    }
    return result
  }
}
