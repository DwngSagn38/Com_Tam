package com.example.com_tam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.com_tam.model.MonAnModel
import com.example.com_tam.repository.RepositoryMonAn
import kotlinx.coroutines.launch

class MonAnViewModel(val repository: RepositoryMonAn): ViewModel() {

    fun addMonAn(tenMon: String, gia : String, idLoai : String, hinhAnh : String?) : String {
        if (tenMon.isEmpty() || gia.isEmpty() || idLoai.isEmpty() || hinhAnh.isNullOrEmpty()){
            return "Khong duoc de trong thong tin"
        }else if (!isFloat(gia)){
            return "Gia khong hop le"
        }else {
            val monAnModel = MonAnModel(0,tenMon,gia.toFloat(),hinhAnh,idLoai.toInt())
            viewModelScope.launch {
                repository.addMonAn(monAnModel)
            }
            return "Them thanh cong"
        }
    }

    val listMonAn = repository.getAll()

    fun deleteMonAn(monAnModel: MonAnModel) {
        viewModelScope.launch {
            repository.deleteMonAn(monAnModel)
        }
    }

    fun updateMonAn(monAnModel: MonAnModel) {
        viewModelScope.launch {
            repository.updateMonAn(monAnModel)
        }
    }

    fun getMonAnById(idMonAn : Int){
        repository.getMonAnByID(idMonAn)
    }
}

fun isFloat(value: String): Boolean {
    return try {
        value.toFloat()
        true
    } catch (e: NumberFormatException) {
        false
    }
}