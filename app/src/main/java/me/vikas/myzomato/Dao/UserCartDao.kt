package me.vikas.myzomato.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import me.vikas.myzomato.Model.CompletedUserCart
import me.vikas.myzomato.Model.MenuCart
import me.vikas.myzomato.Model.MenuCompleted
import me.vikas.myzomato.Model.UserCart
import me.vikas.myzomato.Util.App

@Dao
interface UserCartDao {

    @Insert
    fun addItem(item: UserCart)

    @Insert
    fun addOrder(item: CompletedUserCart)

    @Query("select * from ${App.CART_TABLE} where ${App.COLUMN_CART_MENU_ID} = :itemID")
    fun getItemByMenuID(itemID:String): LiveData<UserCart>

    @Query("select * from ${App.CART_TABLE} where ${App.COLUMN_CART_MENU_ID} = :itemID")
    fun getItemByMenuID2(itemID:String): UserCart

    @Query("select * from ${App.CART_TABLE} where ${App.COLUMN_CART_RESTAURANT_ID} = :itemID")
    fun getItemByRestaurantID(itemID:String): LiveData<List<UserCart>>

    @Update
    fun updateCartItem(item:UserCart)

    @Delete
    fun clearCartItem(item: UserCart)

    @Query("select * from ${App.CART_TABLE}")
    fun getUserCartItems():List<MenuCart>

    @Query("select * from ${App.CART_TABLE} where ${App.COLUMN_CART_RESTAURANT_ID}=:restroID")
    fun getUserCartByRestaurantIDItems(restroID:String):LiveData<List<MenuCart>>

    @Query(value = "select * from ${App.ORDER_COMPLETED}")
    fun getCompletedOrders():List<MenuCompleted>
}