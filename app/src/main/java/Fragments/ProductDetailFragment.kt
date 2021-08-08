package Fragments

import Models.Dish
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.ProductDetailFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ProductDetailFragment : BottomSheetDialogFragment() {

  lateinit var binding: ProductDetailFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    this.binding = ProductDetailFragmentBinding.inflate(layoutInflater, container, false)
    return this.binding.root
  }

}