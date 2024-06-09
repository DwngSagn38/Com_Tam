package com.example.com_tam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.com_tam.model.MonAnModel
import com.example.com_tam.repository.RepositoryMonAn
import kotlinx.coroutines.launch

class MonAnViewModel(val repository: RepositoryMonAn): ViewModel() {

    fun addMonAn(monAnModel: MonAnModel) {
        viewModelScope.launch {
            repository.addMonAn(monAnModel)
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