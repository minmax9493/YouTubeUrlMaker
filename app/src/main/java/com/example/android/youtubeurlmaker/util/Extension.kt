package com.example.android.youtubeurlmaker.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by murodjon on 2020/04/19
 */

fun Date.formattedDate():String{
    val sdf = SimpleDateFormat("dd/M/yyyy")
    return sdf.format(Date())
}