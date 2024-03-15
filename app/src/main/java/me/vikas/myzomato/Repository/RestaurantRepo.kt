package me.vikas.myzomato.Repository

import androidx.lifecycle.LiveData
import me.vikas.myzomato.Dao.RestaurantDao
import me.vikas.myzomato.Model.Restaurant
import me.vikas.myzomato.Model.RestaurantMenu

class RestaurantRepo(private val restaurantDao: RestaurantDao) {

    fun addRestaurant(restaurant: List<Restaurant>) {
        restaurantDao.addRestaurant(restaurant)
    }

    fun getRestaurantMenu(id: String): LiveData<RestaurantMenu> {
       return restaurantDao.getRestaurantMenu(id)
    }

    fun getRestaurants():List<Restaurant>{
        return restaurantDao.getAllRestaurants()
    }
}