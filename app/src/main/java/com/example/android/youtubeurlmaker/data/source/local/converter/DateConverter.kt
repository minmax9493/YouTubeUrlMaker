package com.example.android.youtubeurlmaker.data.source.local.converter

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by murodjon on 2020/04/18
 */
class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}