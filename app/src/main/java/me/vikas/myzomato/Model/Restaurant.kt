package me.vikas.myzomato.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.vikas.myzomato.Util.App

@Entity(tableName = App.RESTAURANT_TABLE_NAME)
data class Restaurant(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_NAME) val name: String,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_DESCRIPTION) val description: String,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_LOCATION) val location: String,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_AVERAGE_RATING) val averageRating: Double,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_RATINGS) val ratings: Int,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_FEATURE) val feature: String,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_isVEG) val isVeg: Boolean,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_TYPE) val restaurantType: String,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_DISTANCE) val distance: String,
    @ColumnInfo(name = App.COLUMN_RESTAURANT_TIME) val time: String
) {
    constructor(
        name: String,
        location: String,
        restaurantType: String,
        description: String,
        feature: String,
        isVeg: Boolean,
        ratings: Int,
        averageRating: Double,
        distance: String,
        time: String
    ) : this(
        id = 0,
        name,
        description,
        location,
        averageRating,
        ratings,
        feature,
        isVeg,
        restaurantType,
        distance,
        time
    )
}