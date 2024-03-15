package me.vikas.myzomato.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vikas.myzomato.Interface.CartItemHandler
import me.vikas.myzomato.Model.MenuCart
import me.vikas.myzomato.Model.MenuCompleted
import me.vikas.myzomato.databinding.ItemCartBinding

class OrdersHistoryAdapter(
    val context: Context,
    val list: List<MenuCompleted>,
    val handler: CartItemHandler
) : RecyclerView.Adapter<OrdersHistoryAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemCartBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.element.itemName.text = list[position].menu.name
        holder.element.itemCount.text = list[position].cartItem.itemCount1.toString()
        holder.element.itemCost.text = "₹${list[position].cartItem.basePrice1}"
        holder.element.payableAmount.text = "₹${list[position].cartItem.itemCount1 * list[position].cartItem.basePrice1}"

        if (!list[position].menu.isVeg) {
            holder.element.isVeg.visibility = View.INVISIBLE
        }
    }

    @SuppressLint("ResourceAsColor")
    inner class ItemViewHolder(itemView: ItemCartBinding) : RecyclerView.ViewHolder(itemView.root) {
        val element = itemView

        init {
//            element.addBtn.setOnClickListener {
//                onAddBtnClick()
//            }
//            element.subBtn.setOnClickListener {
//                onSubBtnClick()
//            }
        }

//        private fun onAddBtnClick() {
//            handler.onItemClick(list[adapterPosition].cartItem, ++list[adapterPosition].cartItem.itemCount1)
//        }
//
//        private fun onSubBtnClick() {
//            handler.onItemClick(list[adapterPosition].cartItem, --list[adapterPosition].cartItem.itemCount1)
//        }
    }
}