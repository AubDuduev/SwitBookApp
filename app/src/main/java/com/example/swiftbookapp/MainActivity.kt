package com.example.swiftbookapp

import LessonKotlin.Animalble
import LessonKotlin.Cat
import LessonKotlin.Dog
import LessonKotlin.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.lang.Math.PI
import java.lang.Math.pow
import java.util.*
import kotlin.math.sqrt
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.basket_layout)

    //Kotlin 2.5 Урок 2
    val dog: Animalble = Dog()
    val cat: Animalble = Cat()

    dog.voice()
    cat.voice()

    (dog as? Dog)?.bite()
    (cat as? Cat)?.scratch()

    //Kotlin 2.5 Урок 3
    val persons = mutableListOf<Person>()

    for (i in (0..15).withIndex()){

      val age    = (20..100).random()
      val name   = "Person ${i.value}"
      val person = Person(name, age)
      persons.add(i.index, person)
    }

    persons.forEach { it
      print("Person age: ${it.age}")
      print("Person name: ${it.name}")
    }

    val personAge50 = persons.find { it.age == 50 }
    print("Person age find $personAge50")

    val personsAgeFrom30To70 = persons.filter { (it.age > 30 && it.age < 70) }

    personsAgeFrom30To70.forEach { it
      print("Person age: ${it.age}")
      print("Person name: ${it.name}")
    }
  }


}
