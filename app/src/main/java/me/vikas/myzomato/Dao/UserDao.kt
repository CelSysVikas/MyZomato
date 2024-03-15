package me.vikas.myzomato.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import me.vikas.myzomato.Model.User
import me.vikas.myzomato.Util.App

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

    @Delete
    fun deleteUSer(user: User)

    @Update
    fun updateUser(user: User)

    @Query("select * from ${App.USER_TABLE_NAME} where ${App.COLUMN_USER_PHONE_NUMBER}= :phone")
    fun checkUser(phone: String): User
}