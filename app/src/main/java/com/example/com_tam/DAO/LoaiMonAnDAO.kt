package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.com_tam.model.LoaiMonAnModel
import kotlinx.coroutines.flow.Flow

@Dao
interface LoaiMonAnDAO{
    // get list danh sach Loai Mon An
    @Query("SELECT * FROM LoaiMon")
    fun getListLoaiMon() : Flow<List<LoaiMonAnModel>>

    // lay 1 Loai Mon An theo id
    @Query("SELECT * FROM LoaiMon WHERE id = :id LIMIT 1")
    fun getLoaiMon(id : Int) : LoaiMonAnModel?

    // them Loai mon an
    @Insert
    suspend fun addLoaiMon(vararg loaiMon : LoaiMonAnModel)

    // xoa loai mon an
    @Delete
    suspend fun deleteLoaiMon(loaiMon: LoaiMonAnModel)

    // sửa loại mon an
    @Update
    suspend fun updateLoaiMon(loaiMon: LoaiMonAnModel)
}