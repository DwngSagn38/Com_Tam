package com.example.com_tam.repository

import android.service.autofill.UserData
import com.example.com_tam.database.DBHelper
import com.example.com_tam.model.UserModel

class RepositoryUser(val userDB : DBHelper) {
    suspend fun addUser(userModel: UserModel){
        userDB.userDAO().addUser(userModel)
    }

    fun getAll () = userDB.userDAO().getListUser()

    fun getUserByEmail(email : String){
        userDB.userDAO().getUser(email)
    }
}