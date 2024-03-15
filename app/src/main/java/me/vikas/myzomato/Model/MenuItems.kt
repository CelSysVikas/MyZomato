package me.vikas.myzomato.Model

import androidx.room.Embedded
import androidx.room.Relation
import me.vikas.myzomato.Util.App

data class MenuItems(
    @Embedded
    val menu: RestaurantMenuItem,

    @Relation(
        parentColumn = "id",
        entityColumn = App.COLUMN_ORDER_ITEM_MENU_ID
    )
    val items: List<Items>? = null
)
