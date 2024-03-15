package me.vikas.myzomato.Adapter

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import me.vikas.myzomato.Interface.OrderItemHandler
import me.vikas.myzomato.Model.RestaurantMenuItem
import me.vikas.myzomato.R
import me.vikas.myzomato.ViewModels.UserCartViewModel
import me.vikas.myzomato.databinding.ItemMenuBinding

class RestaurantMenuAdapter(
    val context: Context,
    val list: List<RestaurantMenuItem>,
    val handler: OrderItemHandler
) : RecyclerView.Adapter<RestaurantMenuAdapter.ItemViewHolder>() {

    private val TAG = "RestaurantMenuAdapter"
    private lateinit var userCartViewModel: UserCartViewModel


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemMenuBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        userCartViewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(context.applicationContext as Application)
                .create(UserCartViewModel::class.java)

        holder.element.menuItemName.text = list[position].name
        holder.element.ratings.text = "${list[position].ratings} ratings"
        holder.element.description.text = list[position].description
        holder.element.price.text = " ₹${list[position].price}"
        holder.element.menuImage.setImageResource(list[position].drawable)
        holder.element.averageRating.rating = list[position].averageRating.toFloat()


        if (!list[position].isVeg) {
            holder.element.isVeg.visibility = View.INVISIBLE
        }

        userCartViewModel.getItemByMenuId(list[position].id.toString())
            .observe(context as LifecycleOwner, Observer {

                if (it != null) {
                    if (it.isOrderCompleted){
                        holder.reset()
                    }else{
                        holder.itemCount = it.itemCount1
                        holder.initUserCart(it.itemCount1)
                    }
                } else {
                    holder.reset()
                }
            })

    }

    @SuppressLint("ResourceAsColor")
    inner class ItemViewHolder(itemView: ItemMenuBinding) : RecyclerView.ViewHolder(itemView.root) {
        val element = itemView
        var itemCount: Int = 0

        init {
            element.addBtn.setOnClickListener {
                itemCount++
                handler.updateCart(list[adapterPosition], itemCount)
                onAddBtnClick()
            }
            element.subBtn.setOnClickListener {
                onSubBtnClick()
            }

        }

        private fun onAddBtnClick() {
            element.itemCount.text = itemCount.toString()
            element.subBtn.visibility = View.VISIBLE
            element.itemCount.setTextColor(ContextCompat.getColor(context, R.color.white))
            element.parentItemCount.background.setTint(
                ContextCompat.getColor(
                    context,
                    R.color.primaryLite
                )
            )

            element.addBtn.setColorFilter(R.color.white)
        }

        fun onSubBtnClick() {
            if (itemCount < 1) {
                handler.updateCart(list[adapterPosition], itemCount)
                reset()
                return
            }
            itemCount--
            element.itemCount.text = itemCount.toString()
            handler.updateCart(list[adapterPosition], itemCount)
        }

        fun reset() {
            itemCount = 0
            element.subBtn.visibility = View.GONE
            element.parentItemCount.background.setTint(
                ContextCompat.getColor(context, R.color.fadeBtn)
            )

            element.itemCount.setTextColor(ContextCompat.getColor(context, R.color.primaryLite))
            element.itemCount.text = "ADD"
        }

        fun initUserCart(count: Int) {
            itemCount = count
            onAddBtnClick()
        }
    }
}