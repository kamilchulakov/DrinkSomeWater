package com.github.ulyanovskk.drinksomewater2.model

import javax.inject.Inject

class Repository() {
    @Inject
    lateinit var db: AppDatabase
    fun getDao(): NoteDao {
        return db.noteDao()
    }
}