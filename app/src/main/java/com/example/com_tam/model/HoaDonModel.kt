package com.example.com_tam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HoaDon")
data class HoaDonModel(
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    @ColumnInfo(name = "idUser") var idUser : Int?,
    @ColumnInfo(name = "idMonAn") var idMonAn : Int?,
    @ColumnInfo(name = "tongTien") var tongTiem : Float?,
    @ColumnInfo(name = "ngayMua") var ngayMua : String?,
    @ColumnInfo(name = "trangThai") var trangThai : Boolean?,
) {
}