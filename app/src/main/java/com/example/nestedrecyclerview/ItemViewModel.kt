package com.example.nestedrecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemViewModel: ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    fun read(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Database.db.itemDao().getAll()
            }
        }
    }

    fun write(title: String, description: String, imageUrl: String){
        val user = Item(title, description, imageUrl)
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Database.db.itemDao().insertUser(user)
            }
        }
    }
}