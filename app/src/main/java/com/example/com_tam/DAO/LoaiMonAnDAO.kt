package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.com_tam.model.LoaiMonAnModel

@Dao
interface LoaiMonAnDAO{
    // get list danh sach Loai Mon An
    @Query("SELECT * FROM LoaiMon")
    fun getListLoaiMon() : List<LoaiMonAnModel>

    // lay 1 Loai Mon An theo id
    @Query("SELECT * FROM LoaiMon WHERE id = :id LIMIT 1")
    fun getLoaiMon(id : Int) : LoaiMonAnModel?

    // them Loai mon an
    @Insert
    fun addLoaiMon(vararg loaiMon : LoaiMonAnModel)

    // xoa loai mon an
    @Delete
    fun deleteLoaiMon(loaiMon: LoaiMonAnModel)

    // sửa loại mon an
    @Update
    fun updateLoaiMon(loaiMon: LoaiMonAnModel)
}