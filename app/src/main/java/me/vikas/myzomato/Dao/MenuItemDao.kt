package me.vikas.myzomato.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.vikas.myzomato.Model.MenuItems
import me.vikas.myzomato.Model.RestaurantMenu
import me.vikas.myzomato.Model.RestaurantMenuItem
import me.vikas.myzomato.Util.App

@Dao
interface MenuItemDao {

    @Insert
    fun addItem(item: List<RestaurantMenuItem>)

    @Query("select * from ${App.MENU_TABLE_NAME}")
    fun allItems(): List<RestaurantMenuItem>

    @Query("select * from ${App.MENU_TABLE_NAME}")
    fun getMenuItems():List<MenuItems>
}