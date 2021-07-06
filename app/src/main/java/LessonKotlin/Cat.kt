package LessonKotlin
import android.util.Log

class Cat: Animalble {

  override fun voice() {
    print("Мяу")
  }
  fun scratch(){
    print("Царапать")
  }
}