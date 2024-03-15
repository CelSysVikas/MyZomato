package me.vikas.myzomato.Model

import androidx.room.Embedded
import androidx.room.Relation
import me.vikas.myzomato.Util.App

data class MenuCart(
    @Embedded
    val cartItem: UserCart,

    @Relation(
        parentColumn = App.COLUMN_CART_MENU_ID,
        entityColumn = "id"
    )
    val menu: RestaurantMenuItem,

    @Relation(
        parentColumn = App.COLUMN_CART_RESTAURANT_ID,
        entityColumn = "id"
    )
    val restaurant: Restaurant
)

data class MenuCompleted(
    @Embedded
    val cartItem: CompletedUserCart,

    @Relation(
        parentColumn = App.COLUMN_CART_MENU_ID,
        entityColumn = "id"
    )
    val menu: RestaurantMenuItem
)
