package com.example.com_tam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserModel (
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    @ColumnInfo(name = "username") var username : String?,
    @ColumnInfo(name = "password") var password : String?,
    @ColumnInfo(name = "role") var role : Int?
){
}