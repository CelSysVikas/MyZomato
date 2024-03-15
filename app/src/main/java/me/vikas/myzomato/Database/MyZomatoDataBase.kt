package me.vikas.myzomato.Database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.vikas.myzomato.Dao.MenuItemDao
import me.vikas.myzomato.Dao.OrderItemDao
import me.vikas.myzomato.Dao.RestaurantDao
import me.vikas.myzomato.Dao.UserCartDao
import me.vikas.myzomato.Model.CompletedUserCart
import me.vikas.myzomato.Model.Items
import me.vikas.myzomato.Model.Restaurant
import me.vikas.myzomato.Model.RestaurantMenuItem
import me.vikas.myzomato.Model.UserCart
import me.vikas.myzomato.Util.App

@Database(
    entities = [Restaurant::class, RestaurantMenuItem::class, Items::class, UserCart::class,CompletedUserCart::class],
    exportSchema = false,
    version = 1
)
abstract class MyZomatoDataBase : RoomDatabase() {

    companion object {

        @Volatile
        private var INSTANCE: MyZomatoDataBase? = null

        fun getInstance(context: Application): MyZomatoDataBase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        // Create the database instance
        private fun buildDatabase(context: Application): MyZomatoDataBase {
            return Room.databaseBuilder(
                context,
                MyZomatoDataBase::class.java,
                App.DATABASE
            )
                .allowMainThreadQueries()
                .build()
        }
    }


    abstract fun getRestroDao(): RestaurantDao
    abstract fun getMenuItemDao(): MenuItemDao
    abstract fun getOrderItemDao(): OrderItemDao
    abstract fun getUserCartDao(): UserCartDao
}