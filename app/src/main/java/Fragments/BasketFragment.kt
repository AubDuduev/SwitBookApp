package Fragments

import Activity.MainActivity
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
  private lateinit var txvPhoneNumber : TextView
  private lateinit var ibExit         : ImageButton
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
    this.createElement(view)
    this.setNumber()
    this.addListenerExitButton()
  }

  private fun createElement(view: View){
    this.txvPhoneNumber = this.binding.tvPhoneNumber
    this.ibExit         = this.binding.ibExit
  }

  private fun setNumber(){
    this.numberPhoneUser = arguments?.getString(PHONE_NUMBER_KEY).toString()
    this.txvPhoneNumber.text = this.numberPhoneUser
  }

  private fun addListenerExitButton(){
    this.ibExit.setOnClickListener {
      (activity as MainActivity).supportFragmentManager.popBackStack()
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
