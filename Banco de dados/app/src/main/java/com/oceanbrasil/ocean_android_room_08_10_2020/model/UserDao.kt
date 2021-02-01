package com.oceanbrasil.ocean_android_room_08_10_2020.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query ("SELECT name FROM usernames WHERE name == id")
    fun clone()

    @Query("SELECT * FROM usernames ORDER BY name ASC")
    fun getAllUsernames(): LiveData<List<User>>
}