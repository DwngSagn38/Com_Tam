package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.com_tam.model.HoaDonModel


@Dao
interface HoaDonDAO{
    // get list danh sach Hoa Don
    @Query("SELECT * FROM HoaDon")
    fun getListHoaDon() : List<HoaDonModel>

    // them hoa don
    @Insert
    fun addHoaDon(vararg hd : HoaDonModel)

}