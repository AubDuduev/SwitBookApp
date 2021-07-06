package LessonKotlin

class GeometricFigures {

  fun completion(){
    val radiusCircle: Double = 5.0
    val sideSquare  : Double = 5.0
    val circleArea = this.areaOfCircleCalculator(radiusCircle)
    val squareArea = this.areaOfSquareCalculator(sideSquare)

    val comparisonResult = this.compareTheAreaOfSquareAndCircle(squareArea, circleArea)
  }

  //S = π * r2
  private fun areaOfCircleCalculator(x: Double): Double = Math.PI * (x * x)

  //S = a2
  private fun areaOfSquareCalculator(x: Double): Double = x * x


  private fun compareTheAreaOfSquareAndCircle(square: Double, circle: Double): String {

    val result = when {

      square == circle -> "Площади равны"

      square > circle -> "Площадь квадрата больше"

      square < circle -> "Площадь круга больше"

      else -> "Резултат не известен"

    }
    return result
  }
}