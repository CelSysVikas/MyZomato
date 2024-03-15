package me.vikas.myzomato.Repository

import me.vikas.myzomato.Dao.OrderItemDao
import me.vikas.myzomato.Model.Items

class OrderItemRepo(private val orderItemDao: OrderItemDao) {

    fun addItem(item: List<Items>) {
        orderItemDao.addItem(item)
    }
}