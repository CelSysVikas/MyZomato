package me.vikas.myzomato.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import me.vikas.myzomato.Database.MyZomatoDataBase
import me.vikas.myzomato.Model.CompletedUserCart
import me.vikas.myzomato.Model.MenuCart
import me.vikas.myzomato.Model.MenuCompleted
import me.vikas.myzomato.Model.UserCart
import me.vikas.myzomato.Repository.UserCartRepo

class UserCartViewModel(application: Application) : AndroidViewModel(application) {

    var userCartRepo: UserCartRepo

    init {
        userCartRepo =
            UserCartRepo(MyZomatoDataBase.getInstance(application).getUserCartDao())
    }

    fun addItem(item: UserCart) {
        userCartRepo.addItem(item)
    }

    fun addCompletedOrder(item: CompletedUserCart) {
        userCartRepo.addCompletedOrder(item)
    }

    fun getItemByMenuId(itemID:String):LiveData<UserCart>{
       return userCartRepo.getItemByMenuID(itemID)
    }

    fun getItemByMenuID2(itemID: String): UserCart {
        return userCartRepo.getItemByMenuID2(itemID)
    }

    fun getItemByRestaurantID(itemID: String): LiveData<List<UserCart>> {
        return userCartRepo.getItemByRestaurantID(itemID)
    }

    fun updateCartItem(item:UserCart) {
        return userCartRepo.updateCartItem(item)
    }

    fun clearCartItem(item:UserCart) {
        return userCartRepo.clearCartItem(item)
    }

    fun getUserCartItem():List<MenuCart> {
        return userCartRepo.getUserCartItem()
    }

    fun getUserCartByRestaurantIDItems(restroID:String):LiveData<List<MenuCart>> {
        return userCartRepo.getUserCartByRestaurantIDItems(restroID)
    }

    fun getCompletedOrders():List<MenuCompleted> {
        return userCartRepo.getCompletedOrders()
    }

//    fun menuItems():List<MenuItems>{
//       return menuItemRepo.menuItems()
//    }
}