package me.vikas.myzomato.Repository

import androidx.lifecycle.LiveData
import me.vikas.myzomato.Dao.UserCartDao
import me.vikas.myzomato.Model.CompletedUserCart
import me.vikas.myzomato.Model.MenuCart
import me.vikas.myzomato.Model.MenuCompleted
import me.vikas.myzomato.Model.UserCart

class UserCartRepo(private val userCartDao: UserCartDao) {

    fun addItem(item: UserCart) {
        userCartDao.addItem(item)
    }

    fun addCompletedOrder(item: CompletedUserCart) {
        userCartDao.addOrder(item)
    }

    fun getItemByMenuID(itemID: String): LiveData<UserCart> {
        return userCartDao.getItemByMenuID(itemID)
    }

    fun getItemByMenuID2(itemID: String): UserCart {
        return userCartDao.getItemByMenuID2(itemID)
    }

    fun getItemByRestaurantID(itemID: String): LiveData<List<UserCart>> {
        return userCartDao.getItemByRestaurantID(itemID)
    }

    fun updateCartItem(item: UserCart) {
        return userCartDao.updateCartItem(item)
    }

    fun clearCartItem(item: UserCart) {
        return userCartDao.clearCartItem(item)
    }

    fun getUserCartItem():List<MenuCart> {
        return userCartDao.getUserCartItems()
    }

    fun getUserCartByRestaurantIDItems(restroID:String):LiveData<List<MenuCart>> {
        return userCartDao.getUserCartByRestaurantIDItems(restroID)
    }
fun getCompletedOrders():List<MenuCompleted>{
        return userCartDao.getCompletedOrders()
    }


}