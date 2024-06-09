package com.example.com_tam.repository

import com.example.com_tam.database.DBHelper
import com.example.com_tam.model.LoaiMonAnModel

class RepositoryLoaiMon(val loaiMonDB : DBHelper) {
    fun getAll() = loaiMonDB.loaimonDAO().getListLoaiMon()

    suspend fun addLoaiMon(loaiMonAnModel: LoaiMonAnModel){
        loaiMonDB.loaimonDAO().addLoaiMon(loaiMonAnModel)
    }

    suspend fun deleteLoaiMon(loaiMonAnModel: LoaiMonAnModel){
        loaiMonDB.loaimonDAO().deleteLoaiMon(loaiMonAnModel)
    }

    suspend fun updateLoaiMon(loaiMonAnModel: LoaiMonAnModel){
        loaiMonDB.loaimonDAO().updateLoaiMon(loaiMonAnModel)
    }

    fun getLoaiMonByID(idLoaiMon : Int){
        loaiMonDB.loaimonDAO().getLoaiMon(idLoaiMon)
    }
}