package com.example.swiftbookapp

import LessonKotlin.Animalble
import LessonKotlin.Cat
import LessonKotlin.Dog
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


    val dog: Animalble = Dog()
    val cat: Animalble = Cat()

    dog.voice()
    cat.voice()

    (dog as? Dog)?.bite()
    (cat as? Cat)?.scratch()
  }

}
