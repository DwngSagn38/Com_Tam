package com.example.com_tam.database

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import com.example.com_tam.DAO.HoaDonDAO
import com.example.com_tam.DAO.LoaiMonAnDAO
import com.example.com_tam.DAO.MonAnDAO
import com.example.com_tam.DAO.UserDAO
import com.example.com_tam.model.HoaDonModel
import com.example.com_tam.model.LoaiMonAnModel
import com.example.com_tam.model.MonAnModel
import com.example.com_tam.model.UserModel

@Database(
    entities = [UserModel::class, LoaiMonAnModel::class, MonAnModel::class, HoaDonModel::class],
    version = 1)
abstract class DBHelper : RoomDatabase(){
    abstract fun userDAO() : UserDAO
    abstract fun loaimonDAO() : LoaiMonAnDAO
    abstract fun monanDAO() : MonAnDAO
    abstract fun hoadonDAO() : HoaDonDAO

    companion object {
        private var INSTANCE: DBHelper? = null

        //phương thức getInstance() để lấy một phiên bản duy nhất của DBHelper
        fun getInstance(context: Context): DBHelper {
            if (INSTANCE == null) {
                synchronized(DBHelper::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DBHelper::class.java,
                        "comtam.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}



