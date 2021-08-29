package com.github.ulyanovskk.drinksomewater2.utils

import java.text.SimpleDateFormat
import java.util.*

fun getCurrentData(): String {
    val sdf = SimpleDateFormat("dd/mm/yyyy")
    val sdfTime = SimpleDateFormat("HH:MM")
    return sdf.format(Date())
}

fun getYesterdayData(): String {
    val today = getCurrentData()
    return "${Integer.parseInt(today.split("/")[0]) - 1}/${today.split("/").joinToString("/")}"
}

fun getCurrentTime(): String {
    val sdf = SimpleDateFormat("dd/mm/yyyy")
    val sdfTime = SimpleDateFormat("HH:MM")
    return sdfTime.format(Date())
}