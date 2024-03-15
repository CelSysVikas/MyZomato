package me.vikas.myzomato.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.vikas.myzomato.Model.Items
import me.vikas.myzomato.Model.RestaurantMenuItem
import me.vikas.myzomato.Util.App

@Dao
interface OrderItemDao {

    @Insert
    fun addItem(item: List<Items>)

    @Query("select * from ${App.ORDER_TABLE_NAME}")
    fun allOrderItems(): List<Items>

}