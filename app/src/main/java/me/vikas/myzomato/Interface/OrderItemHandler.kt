package me.vikas.myzomato.Interface

import me.vikas.myzomato.Model.RestaurantMenuItem

interface OrderItemHandler {
    fun updateCart(item: RestaurantMenuItem, count: Int)
}