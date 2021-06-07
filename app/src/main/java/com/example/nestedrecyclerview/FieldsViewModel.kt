package com.example.nestedrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FieldsViewModel : ViewModel() {

    private val fieldsLiveData = MutableLiveData<MutableList<MutableList<FieldData>>>().apply {
        mutableListOf<MutableList<FieldData>>()
    }

    val _fieldsLiveData: MutableLiveData<MutableList<MutableList<FieldData>>> = fieldsLiveData

//    private val finalMap = MutableLiveData<Map<String, List<String>>>().apply {
//        mutableMapOf<String, Boolean>()
//    }
//
//    val _finalMap: MutableLiveData<Map<String, List<String>>> = finalMap

    fun init() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getFields()
            }
        }
    }

    private suspend fun getFields() {
        val response = RetrofitService.retrofitService().getFields()
        if (response.isSuccessful) {
            val fields = response.body()
            fieldsLiveData.postValue(fields)
        } else {
            response.code()
        }
    }
}