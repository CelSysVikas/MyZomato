package me.vikas.myzomato.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import me.vikas.myzomato.Database.MyZomatoDataBase
import me.vikas.myzomato.Model.Restaurant
import me.vikas.myzomato.Model.RestaurantMenu
import me.vikas.myzomato.Repository.RestaurantRepo

class RestaurantViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var restaurantRepo:RestaurantRepo

    init {
        restaurantRepo=
            RestaurantRepo(MyZomatoDataBase.getInstance(application).getRestroDao())
    }

    fun addRestaurant(restaurant: List<Restaurant>){
        restaurantRepo.addRestaurant(restaurant)
    }

    fun getRestaurantMenu(id: String): LiveData<RestaurantMenu> {
        return restaurantRepo.getRestaurantMenu(id)
    }

    fun getRestaurants():List<Restaurant>{
        return restaurantRepo.getRestaurants()
    }
}