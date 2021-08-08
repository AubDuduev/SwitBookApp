package Fragments

import Activity.MainActivity
import Interfaces.MainNavigationInterface
import Models.UserData
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.AuthFragmentBinding

class AuthFragment: Fragment() {

  private lateinit var userData         : UserData
  private lateinit var etPhoneNumberUser: EditText
  private lateinit var btnBegin         : Button
  private lateinit var numberPhoneUser  : String
  private lateinit var binding          : AuthFragmentBinding

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    this.binding = AuthFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.createElements(view)
    this.btnBeginListener()
  }


  private fun createElements(view: View){
    this.etPhoneNumberUser = this.binding.etPhoneNumberUser
    this.btnBegin = this.binding.btnBegin
  }

  private fun btnBeginListener(){
    btnBegin.setOnClickListener {
      (activity as? MainNavigationInterface)?.pushBottomMenuActivity()
      Log.d("TAG", "btnBeginListener")
    }
  }
//  private fun btnBeginListener(){
//
//    btnBegin.setOnClickListener {
//      this.numberPhoneUser = this.etPhoneNumberUser.text.toString()
//      Log.d("TAG", "numberPhoneUser ${this.numberPhoneUser.toString()}")
//      (activity as? MainNavigationInterface)?.openBasketFragment(numberPhoneUser = this.numberPhoneUser.toString())
//    }
//  }


}