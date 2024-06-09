package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.com_tam.model.UserModel

@Dao
interface UserDAO {

    // get list danh sach user
    @Query("SELECT * FROM User")
    fun getListUser() : List<UserModel>

    // lay 1 user theo username de Dang Nhap
    @Query("SELECT * FROM User WHERE email = :username LIMIT 1")
    fun getUser(username : String) : UserModel?

    // them user
    @Insert
    fun addUser(vararg user : UserModel)
}
