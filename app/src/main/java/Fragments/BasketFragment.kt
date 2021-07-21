package Fragments

import Activity.MainActivity
import Interfaces.MainNavigationInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.AuthFragmentBinding
import com.example.swiftbookapp.databinding.BasketFragmnetBinding

class BasketFragment : Fragment() {

  private lateinit var numberPhoneUser: String
  private lateinit var binding        : BasketFragmnetBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    this.binding = BasketFragmnetBinding.inflate(inflater, container, false)
    return this.binding.root
  }
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.setNumber()
    this.addListenerExitButton()
    this.addListenerProductDetailButton()
  }

  private fun setNumber(){
    this.numberPhoneUser = arguments?.getString(PHONE_NUMBER_KEY).toString()
    this.binding.tvPhoneNumber.text = this.numberPhoneUser
  }
  private fun addListenerProductDetailButton(){
    this.binding.ilDishInfoOne.ivDish.setOnClickListener() {
      (activity as MainNavigationInterface).createProductDetail()
      Log.d("TAG", "Detail product")
    }
    this.binding.ilDishInfoTwo.ivDish.setOnClickListener() {
      (activity as MainNavigationInterface).createProductDetail()
      Log.d("TAG", "Detail product")
    }
    this.binding.ilDishInfoThree.ivDish.setOnClickListener() {
      (activity as MainNavigationInterface).createProductDetail()
      Log.d("TAG", "Detail product")
    }
  }
  private fun addListenerExitButton(){
    this.binding.ibExit.setOnClickListener {
      (activity as MainNavigationInterface).popBackStack()
        Log.d("TAG", "Exit")
    }
  }

  companion object {

    const val PHONE_NUMBER_KEY = "PHONE_NUMBER"

    fun newInstance(numberPhoneUser: String): BasketFragment {
      val fragment = BasketFragment()
      fragment.apply {
        arguments = bundleOf(
          PHONE_NUMBER_KEY to numberPhoneUser
        )
      }
      return fragment
    }
  }
}
