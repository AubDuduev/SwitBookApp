package com.example.swiftbookapp

import LessonKotlin.Animalble
import LessonKotlin.Cat
import LessonKotlin.Dog
import LessonKotlin.Person
import Models.UserData
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class BasketActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.basket_activity)

    this.getUserData()
  }

  private fun getUserData(){

    val userData = intent.getSerializableExtra(USER_DATA_KEY) as UserData

    Log.d("TAG", "${userData.number}")

  }

  companion object {
    private const val USER_DATA_KEY = "userDataKey"

    fun newInstance(fromActivity: Activity, userData: UserData) {
      val myIntent = Intent(fromActivity, BasketActivity::class.java).apply {
        putExtra(USER_DATA_KEY, userData)
      }
      fromActivity.startActivity(myIntent)

    }
  }


  
  private fun lessons(){
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
