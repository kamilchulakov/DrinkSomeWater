package com.github.ulyanovskk.drinksomewater2.history_fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import com.github.ulyanovskk.drinksomewater2.appComponent
import com.github.ulyanovskk.drinksomewater2.model.Repository

class HistoryViewModel(context: Context) : ViewModel() {
    private var repository: Repository = Repository()

    init {
        context.appComponent.inject(repository)
    }
}