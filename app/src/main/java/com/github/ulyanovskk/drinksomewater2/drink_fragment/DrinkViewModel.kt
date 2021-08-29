package com.github.ulyanovskk.drinksomewater2.drink_fragment

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ulyanovskk.drinksomewater2.appComponent
import com.github.ulyanovskk.drinksomewater2.model.Note
import com.github.ulyanovskk.drinksomewater2.model.Repository
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class DrinkViewModel(context: Context): ViewModel() {
    var repository: Repository = Repository()
    private var _liveData = MutableLiveData<Note>()
    val liveData = _liveData
    lateinit var noteCopy: Note

    init {
        context.appComponent.inject(repository)
        initData()
    }

    private fun initData() {
        viewModelScope.launch {
            val data = repository.getTodayData()
            if (isActive) {
                noteCopy = data
                _liveData.value = data
            }
        }
    }

    fun saveData() {
        viewModelScope.launch {
            repository.saveData(noteCopy)
        }
    }
}