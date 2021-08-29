package com.github.ulyanovskk.drinksomewater2.model

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE uid IN (:noteIds)")
    fun loadAllByIds(noteIds: Array<Int>): List<Note>

    @Query("SELECT * FROM note WHERE uid IN (:noteDates)")
    fun loadAllByDates(noteDates: Array<String>): List<Note>

    @Query("SELECT * FROM note WHERE date LIKE :date")
    fun findByDate(date: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Insert
    fun insertAll(defaultNotes: List<Note>)
}