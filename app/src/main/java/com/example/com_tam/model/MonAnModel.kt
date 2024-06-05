package com.example.com_tam.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MonAn")
data class MonAnModel(
    @PrimaryKey(autoGenerate = true) var id : Int = 0,
    @ColumnInfo(name = "tenMon") var tenMon : String?,
    @ColumnInfo(name = "giaBan") var giaBan : Float?,
    @ColumnInfo(name = "hinhAnh") var hinhAnh : String?,
    @ColumnInfo(name = "idLoaiMon") var idLoaiMon : Int?
) {
    fun getThongTinMonAn(): String {
        return "Ten mon an : $tenMon," +
                "Gia ban = $giaBan," +
                "Hinh anh =$hinhAnh," +
                "Loai mon an =$idLoaiMon)"
    }
}