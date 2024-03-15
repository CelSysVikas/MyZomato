package me.vikas.myzomato.Repository

import me.vikas.myzomato.Dao.MenuItemDao
import me.vikas.myzomato.Model.MenuItems
import me.vikas.myzomato.Model.RestaurantMenuItem

class MenuItemRepo(private val menuItemDao: MenuItemDao) {

    fun addItem(item: List<RestaurantMenuItem>) {
        menuItemDao.addItem(item)
    }

    fun menuItems(): List<MenuItems> {
        return menuItemDao.getMenuItems()
    }
}