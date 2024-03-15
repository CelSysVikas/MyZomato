package me.vikas.myzomato.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.vikas.myzomato.Util.App

@Entity(tableName = App.ORDER_TABLE_NAME)
data class Items(
    @PrimaryKey(autoGenerate = true) val itemID: Int,
    @ColumnInfo(name = App.COLUMN_ORDER_ITEM_NAME) val name: String,
    @ColumnInfo(name = App.COLUMN_ORDER_ITEM_PRICE) val price: Int,
    @ColumnInfo(name = App.COLUMN_ORDER_ITEM_ISVEG) val isVeg: Boolean,
    @ColumnInfo(name = App.COLUMN_ORDER_ITEM_REQUIRED_ITEMS) val isRequired:Boolean,
    @ColumnInfo(name = App.COLUMN_ORDER_ITEM_MENU_ID) val menuID:String

){
    constructor(
        name: String,
        price: Int,
        isVeg: Boolean,
        isRequired: Boolean,
        menuID: String
    ):this(itemID=0, name, price, isVeg,isRequired, menuID)
}
