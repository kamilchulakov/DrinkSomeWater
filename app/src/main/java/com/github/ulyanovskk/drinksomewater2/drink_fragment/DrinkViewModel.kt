package com.github.ulyanovskk.drinksomewater2.drink_fragment

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ulyanovskk.drinksomewater2.appComponent
import com.github.ulyanovskk.drinksomewater2.model.Note
import com.github.ulyanovskk.drinksomewater2.model.Repository
import com.github.ulyanovskk.drinksomewater2.utils.getCurrentData
import com.github.ulyanovskk.drinksomewater2.utils.getCurrentTime
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class DrinkViewModel(context: Context): ViewModel() {
    var repository: Repository = Repository()
    private var _liveData = MutableLiveData<Note>(Note(0, getCurrentData(), getCurrentTime(), 0, 2000))
    val liveData = _liveData
    lateinit var noteCopy: Note
    private var initedCopy = false

    init {
        context.appComponent.inject(repository)
        initData()
    }

    private fun initData() {
        viewModelScope.launch {
            if (isActive) {
                val data = repository.getTodayData()
                if (!initedCopy) {
                    Log.d("ViewModel: Copy Init", "Only one time here!")
                    noteCopy = data
                    initedCopy = true
                }
                _liveData.value = data
            }
        }
    }

    fun saveData() {
        viewModelScope.launch {
            if (isActive) repository.saveData(noteCopy)
        }
    }
}