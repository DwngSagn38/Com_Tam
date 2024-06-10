package com.example.com_tam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.com_tam.model.LoaiMonAnModel
import com.example.com_tam.repository.RepositoryLoaiMon
import kotlinx.coroutines.launch

class LoaiMonAnViewModel (val repository: RepositoryLoaiMon):ViewModel(){
    fun addLoaiMonAn(loaiMonAn: LoaiMonAnModel) {
        viewModelScope.launch {
            repository.addLoaiMon(loaiMonAn)
        }
    }

    val loaiMonAns = repository.getAll()

    fun deleteLoaiMonAn(loaiMonAn: LoaiMonAnModel) {
        viewModelScope.launch {
            repository.deleteLoaiMon(loaiMonAn)
        }
    }

    fun updateLoaiMonAn(loaiMonAn: LoaiMonAnModel) {
        viewModelScope.launch {
            repository.updateLoaiMon(loaiMonAn)
        }
    }
}