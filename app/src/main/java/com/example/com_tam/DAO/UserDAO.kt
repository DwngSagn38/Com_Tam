package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.com_tam.model.UserModel

@Dao
interface UserDAO {
    @Query("SELECT * FROM User")
    fun getListUser(): List<UserModel>

    @Query("SELECT * FROM User WHERE email = :username LIMIT 1")
    fun getUser(username: String): UserModel?

    @Insert
    suspend fun addUser(vararg user: UserModel)

    @Query("SELECT * FROM User WHERE id = :userId")
    suspend fun getUserById(userId: Int): UserModel?

    @Update
    suspend fun updateUserById(updatedUser: UserModel)
}

