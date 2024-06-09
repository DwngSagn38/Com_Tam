package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.com_tam.model.HoaDonModel
import kotlinx.coroutines.flow.Flow


@Dao
interface HoaDonDAO{
    // get list danh sach Hoa Don
    @Query("SELECT * FROM HoaDon")
    fun getListHoaDon(): Flow<List<HoaDonModel>>

    // them hoa don
    @Insert
    suspend fun addHoaDon(vararg hd : HoaDonModel)

}