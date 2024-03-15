package me.vikas.myzomato.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import me.vikas.myzomato.Database.MyZomatoDataBase
import me.vikas.myzomato.Model.Items
import me.vikas.myzomato.Model.MenuItems
import me.vikas.myzomato.Repository.OrderItemRepo

class OrderItemViewModel(application: Application) : AndroidViewModel(application) {

    var oderItemRepo: OrderItemRepo

    init {
        oderItemRepo =
            OrderItemRepo(MyZomatoDataBase.getInstance(application).getOrderItemDao())
    }

    fun addItem(item: List<Items>) {
        oderItemRepo.addItem(item)
    }

//    fun menuItems():List<MenuItems>{
//        return ord.menuItems()
//    }
}