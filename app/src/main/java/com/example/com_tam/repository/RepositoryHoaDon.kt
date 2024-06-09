package com.example.com_tam.repository

import com.example.com_tam.database.DBHelper
import com.example.com_tam.model.HoaDonModel

class RepositoryHoaDon(val hoaDonDB : DBHelper) {
    fun getAll() = hoaDonDB.hoadonDAO().getListHoaDon()

    suspend fun addHoaDon(hoaDonModel: HoaDonModel){
        hoaDonDB.hoadonDAO().addHoaDon(hoaDonModel)
    }
}