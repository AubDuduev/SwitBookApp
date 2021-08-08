package DataSources

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swiftbookapp.R

class DishesViewHolder(view: View): RecyclerView.ViewHolder(view) {

  val ivPhoto      : ImageView = view.findViewById(R.id.ivDish)
  val tvPrice      : TextView  = view.findViewById(R.id.tvPrice)
  val tvDescription: TextView  = view.findViewById(R.id.tvCountDish)
  val tvName       : TextView  = view.findViewById(R.id.tvNameDish)
}