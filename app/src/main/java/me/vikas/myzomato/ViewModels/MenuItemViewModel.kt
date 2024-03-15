package me.vikas.myzomato.ViewModels

import me.vikas.myzomato.Model.RestaurantMenuItem
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import me.vikas.myzomato.Database.MyZomatoDataBase
import me.vikas.myzomato.Model.MenuItems
import me.vikas.myzomato.Repository.MenuItemRepo

class MenuItemViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var menuItemRepo:MenuItemRepo

    init {
        menuItemRepo=
            MenuItemRepo(MyZomatoDataBase.getInstance(application).getMenuItemDao())
    }

    fun addItem(restaurantMenuItem: List<RestaurantMenuItem>){
        menuItemRepo.addItem(restaurantMenuItem)
    }

    fun menuItems():List<MenuItems>{
       return menuItemRepo.menuItems()
    }
}