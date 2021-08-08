package DataSources

import Models.Dish
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftbookapp.R

class DishesAdapter(val dishes: List<Dish>): RecyclerView.Adapter<DishesViewHolder>() {

  override fun getItemCount(): Int {
    return dishes.size
  }

  override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {
    holder.ivPhoto.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, dishes[position].image))
    holder.tvName.text  = dishes[position].name
    holder.tvPrice.text = dishes[position].price.toString()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val view: View = inflater.inflate(R.layout.basket_dish_info_item_layout, parent, false)
    return DishesViewHolder(view)
  }

}