package com.example.com_tam.repository

import android.service.autofill.UserData
import com.example.com_tam.DAO.UserDAO
import com.example.com_tam.database.DBHelper
import com.example.com_tam.model.UserModel

class RepositoryUser(val userDB : DBHelper) {
    suspend fun addUser(userModel: UserModel){
        userDB.userDAO().addUser(userModel)
    }

    fun getAll () = userDB.userDAO().getListUser()

    suspend fun getUserByEmail(email: String): UserModel? {
        return userDB.userDAO().getUser(email)
    }

    suspend fun populateDatabase(userDAO: UserDAO) {
        // Thêm người dùng mặc định
        val user = UserModel(
            email = "admin@gmail.com",
            password = "123",
            hoTen = "Hoa Linh",
            soDienThoai = "0352349876",
            role = 0
        )
        userDAO.addUser(user)
    }
}