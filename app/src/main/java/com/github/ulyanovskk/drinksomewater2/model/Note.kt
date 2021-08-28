package com.github.ulyanovskk.drinksomewater2.model

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.INTEGER
import androidx.room.ColumnInfo.TEXT
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid", typeAffinity = INTEGER) val id: Int,
    @ColumnInfo(name="date",typeAffinity = TEXT) val date: String,
    @ColumnInfo(name="last_modification", typeAffinity = TEXT) val timeLastChanged: String,
    @ColumnInfo(name="progress", typeAffinity = INTEGER) var progress: Int,
    @ColumnInfo(name="goal", typeAffinity = INTEGER) val goal: Int
)