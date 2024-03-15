package me.vikas.myzomato.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.vikas.myzomato.Util.App

@Entity(tableName = App.CART_TABLE)
data class UserCart(
    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = App.COLUMN_CART_RESTAURANT_ID) val restroID: String,
    @ColumnInfo(name = App.COLUMN_CART_MENU_ID) val menuID: String,
    @ColumnInfo(name = App.COLUMN_CART_ORDER_ITEM_ID) val orderItemID: String?,
    @ColumnInfo(name = App.COLUMN_CART_BASE_PRICE1) var basePrice1: Int,
    @ColumnInfo(name = App.COLUMN_CART_BASE_PRICE2) val basePrice2: Int?,
    @ColumnInfo(name = App.COLUMN_CART_BASE_PRICE3) val basePrice3: Int?,
    @ColumnInfo(name = App.COLUMN_CART_ITEM_COUNT1) var itemCount1: Int,
    @ColumnInfo(name = App.COLUMN_CART_ITEM_COUNT2) val itemCount2: Int?,
    @ColumnInfo(name = App.COLUMN_CART_ITEM_COUNT3) val itemCount3: Int?,
    @ColumnInfo(name = App.COLUMN_CART_ORDER_COMPLETED) var isOrderCompleted: Boolean
) {
    constructor(
        restroID: String,
        menuID: String,
        orderItemID: String,
        basePrice1: Int,
        basePrice2: Int,
        basePrice3: Int,
        itemCount1: Int,
        itemCount2: Int,
        itemCount3: Int
    ) : this(
        id = 0,
        restroID,
        menuID,
        orderItemID,
        basePrice1,
        basePrice2=null,
        basePrice3=null,
        itemCount1,
        itemCount2=null,
        itemCount3=null,
        isOrderCompleted=false
    )

    constructor(
        restroID: String,
        menuID: String,
        basePrice1: Int,
        itemCount1: Int,
    ) : this(
        id = 0,
        restroID,
        menuID,
        orderItemID=null,
        basePrice1,
        basePrice2=null,
        basePrice3=null,
        itemCount1,
        itemCount2=null,
        itemCount3=null,
        isOrderCompleted=false
    )
}
