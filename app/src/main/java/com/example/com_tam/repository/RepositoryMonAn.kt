package com.example.com_tam.repository

import com.example.com_tam.database.DBHelper
import com.example.com_tam.model.MonAnModel

class RepositoryMonAn(val monAnDB : DBHelper) {
    fun getAll() = monAnDB.monanDAO().getListMonAn()

    suspend fun addMonAn(monAnModel: MonAnModel){
        monAnDB.monanDAO().addMon(monAnModel)
    }

    suspend fun deleteMonAn(monAnModel: MonAnModel){
        monAnDB.monanDAO().deleteMon(monAnModel)
    }

    suspend fun updateMonAn(monAnModel: MonAnModel){
        monAnDB.monanDAO().updateMon(monAnModel)
    }

    fun getMonAnByID(idMonAn : Int){
        monAnDB.monanDAO().getMon(idMonAn)
    }
}