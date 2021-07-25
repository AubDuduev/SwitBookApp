package Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.BasketFragmnetBinding
import com.example.swiftbookapp.databinding.MenuFragmentBinding

class MenuFragment : Fragment() {

  lateinit var binding: MenuFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    this.binding = MenuFragmentBinding.inflate(inflater, container, false)
    return this.binding.root
  }


  companion object {

    const val USER_DATA_KEY = "USER_DATA"

    fun newInstance(): MenuFragment {
      val fragment = MenuFragment()

      return fragment
    }
  }
}