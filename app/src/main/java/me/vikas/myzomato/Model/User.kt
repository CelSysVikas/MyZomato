package me.vikas.myzomato.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.vikas.myzomato.Util.App

@Entity(tableName = App.USER_TABLE_NAME)
data class User(
    @PrimaryKey val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val address: String,
    val isDeliveryPerson: Boolean
)