package Fragments

import DataSources.DishesAdapter
import Models.Dish
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.swiftbookapp.R
import com.example.swiftbookapp.databinding.ListProductsFragmentBinding
import com.example.swiftbookapp.databinding.ProductDetailFragmentBinding

class ListProductsFragment: Fragment() {

  lateinit var binding: ListProductsFragmentBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    this.binding = ListProductsFragmentBinding.inflate(layoutInflater, container, false)
    return this.binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    this.binding.rvDish.adapter = DishesAdapter(this.generatedDish())
    this.binding.rvDish.layoutManager = LinearLayoutManager(requireContext())
  }

  fun generatedDish(): List<Dish>{
    val dish1 = Dish("name one", "Description one", 100, R.drawable.dish_one)
    val dish2 = Dish("name two", "Description two", 200, R.drawable.dish_two)
    val dish3 = Dish("name three", "Description three", 300, R.drawable.dish_three)
    val dish4 = Dish("name fore", "Description fore ", 400, R.drawable.dish_one)
    val dish5 = Dish("name five", "Description five", 500, R.drawable.dish_two)
    val lists = listOf<Dish>(dish1, dish2, dish3, dish4, dish5)
    return lists
  }
}