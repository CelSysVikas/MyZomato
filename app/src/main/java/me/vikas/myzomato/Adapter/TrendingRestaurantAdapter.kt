package me.vikas.myzomato.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vikas.myzomato.Activity.RestaurantActivity
import me.vikas.myzomato.Interface.MenuItemHandler
import me.vikas.myzomato.Model.Restaurant
import me.vikas.myzomato.R
import me.vikas.myzomato.databinding.ItemRestaurants1Binding

class TrendingRestaurantAdapter(
    val context: Context,
    val list: List<Restaurant>,
    val handler: MenuItemHandler
) : RecyclerView.Adapter<TrendingRestaurantAdapter.ItemViewHolder>() {

    val images: List<Int> = listOf(
        R.drawable.img_big_mac,
        R.drawable.img_caffe_americano,
        R.drawable.img_sweets,
        R.drawable.img_snacks,
        R.drawable.img_chicken_mcnuggets
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRestaurants1Binding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.element.tvRestaurantName.text = list[position].name
        holder.element.tvRestaurantFeature.text = list[position].feature
        holder.element.feature2.text = list[position].restaurantType
        holder.element.averageRating.text = list[position].averageRating.toString()
        holder.element.tvTimeTaken.text = list[position].time + " min"
        holder.element.tvDistance.text = list[position].distance
        holder.element.imageSlider.setImageResource(images[position])

        holder.element.parent.setOnClickListener {
            val toRestroActivity = Intent(context, RestaurantActivity::class.java)
            toRestroActivity.putExtra("restroID", list[position].id.toString())
            context.startActivity(toRestroActivity)
        }

    }

    inner class ItemViewHolder(itemView: ItemRestaurants1Binding) :
        RecyclerView.ViewHolder(itemView.root) {
        val element = itemView

        init {
            element.parent.setOnClickListener {
//                handler.onItemClick(list[bindingAdapterPosition].id.toString())
            }
        }
    }

}