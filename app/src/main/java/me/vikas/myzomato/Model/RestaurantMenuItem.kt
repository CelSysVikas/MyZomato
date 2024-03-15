package me.vikas.myzomato.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.vikas.myzomato.Util.App

@Entity(tableName = App.MENU_TABLE_NAME)
data class RestaurantMenuItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_NAME) val name: String,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_DRAWABLE) val drawable: Int,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_DESCRIPTION) val description: String,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_PRICE) val price: Int,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_IsVEG) val isVeg: Boolean,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_AVERAGE_RATING) val averageRating: Double,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_RATINGS) val ratings: Int,
    @ColumnInfo(name = App.COLUMN_MENU_ITEM_CATEGORY) val category: String,
    @ColumnInfo(name = App.COLUMN_MENU_RESTAURANT_ID) val restoID: String
) {
    constructor(
        name: String,
        drawable: Int,
        description: String,
        price: Int,
        isVeg: Boolean,
        averageRating: Double,
        ratings: Int,
        category: String,
        restoID: String
    ) : this(id = 0, name, drawable, description, price, isVeg, averageRating, ratings, category, restoID)
}