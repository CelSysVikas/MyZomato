package me.vikas.myzomato.Model

import androidx.room.Embedded
import androidx.room.Relation
import me.vikas.myzomato.Util.App

data class RestaurantMenu(
    @Embedded
    val restaurant: Restaurant,

    @Relation(
        parentColumn = "id",
        entityColumn = App.COLUMN_MENU_RESTAURANT_ID
    )
    val restaurantMenuItem: List<RestaurantMenuItem>?=null
)
