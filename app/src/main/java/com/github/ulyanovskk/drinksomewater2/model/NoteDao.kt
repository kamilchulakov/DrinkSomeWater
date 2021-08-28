package com.github.ulyanovskk.drinksomewater2.model

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE id IN (:noteIds)")
    fun loadAllByIds(noteIds: Array<String>): List<String>

    @Query("SELECT * FROM note WHERE id IN (:noteDates)")
    fun loadAllByDates(noteDates: Array<String>): List<String>

    @Query("SELECT * FROM note WHERE date LIKE :date")
    fun findByDate(date: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)
}