package com.example.swiftbookapp

import Models.UserData
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AuthActivity : AppCompatActivity() {

  private lateinit var userData: UserData
  private lateinit var txvEnterUserNumber: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.auth_activity)
    this.setTxvEnterUserNumber()
    this.pushBasket()
  }

  private fun setTxvEnterUserNumber(){
    this.txvEnterUserNumber = findViewById<TextView>(R.id.editTextTextPersonName)
  }

  private fun pushBasket(){
    val btnBegin = findViewById<Button>(R.id.btnBegin)
    btnBegin.setOnClickListener {
      val userNumber = this.txvEnterUserNumber.text
      this.userData = UserData(name = "", number = userNumber.toString())
      BasketActivity.newInstance(this, this.userData)
    }
  }
}