package me.vikas.myzomato.Interface

import me.vikas.myzomato.Model.UserCart

interface CartItemHandler {
   fun onItemClick(item:UserCart,count:Int)
}