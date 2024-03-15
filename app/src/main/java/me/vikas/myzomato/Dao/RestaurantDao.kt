package me.vikas.myzomato.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.vikas.myzomato.Model.Restaurant
import me.vikas.myzomato.Model.RestaurantMenu
import me.vikas.myzomato.Util.App

@Dao
interface RestaurantDao {

    @Insert
    fun addRestaurant(restaurant: List<Restaurant>)

    @Query("select * from ${App.RESTAURANT_TABLE_NAME}")
    fun allRestaurant(): List<Restaurant>

    @Query("select * from ${App.RESTAURANT_TABLE_NAME} where id =:id")
    fun getRestaurantMenu(id: String): LiveData<RestaurantMenu>

    @Query("select * from ${App.RESTAURANT_TABLE_NAME}")
    fun getAllRestaurants():List<Restaurant>
}