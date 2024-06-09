package com.example.com_tam.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.com_tam.model.MonAnModel


@Dao
interface MonAnDAO{
    // get list danh sach Mon An
    @Query("SELECT * FROM MonAn")
    fun getListMonAn() : List<MonAnModel>

    // lay 1 Mon An theo id
    @Query("SELECT * FROM MonAn WHERE id = :id LIMIT 1")
    fun getMon(id : Int) : MonAnModel?

    // them mon an
    @Insert
    fun addMon(vararg mon : MonAnModel)

    // xoa mon an
    @Delete
    fun deleteMon(mon: MonAnModel)

    // sửa mon an
    @Update
    fun updateMon(mon: MonAnModel)
}