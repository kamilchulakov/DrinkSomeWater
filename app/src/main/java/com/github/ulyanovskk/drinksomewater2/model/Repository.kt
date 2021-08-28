package com.github.ulyanovskk.drinksomewater2.model

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class Repository() {
    val goal = 2000
    @Inject
    lateinit var db: AppDatabase
    fun getDao(): NoteDao {
        return db.noteDao()
    }
    suspend fun getTodayData(): Note {
        val sdf = SimpleDateFormat("dd/mm/yyyy")
        val sdfTime = SimpleDateFormat("HH:MM")
        val currentDate = sdf.format(Date())
        var result: Note? = null
        withContext(Dispatchers.IO) {
            try {
                result =  getDao().findByDate(currentDate)
            } catch (ex: Exception) {
                Log.e("Repository", ex.toString())
            }
        }
        return result ?: Note(1, currentDate, sdfTime.format(Date()), 0, goal)
    }

    suspend fun saveData(note: Note) {
        withContext(Dispatchers.IO) {
            getDao().insert(note)
        }
    }
}