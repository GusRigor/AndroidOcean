package com.oceanbrasil.ocean_android_room_08_10_2020.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usernames")
data class User(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id : Int ? = 0,
    @NonNull
    val name : String
)