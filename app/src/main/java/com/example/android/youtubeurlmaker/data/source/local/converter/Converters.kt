package com.example.android.youtubeurlmaker.data.source.local.converter

import androidx.room.TypeConverter
import com.example.android.youtubeurlmaker.data.source.local.entity.YouTubeUrlSettings
import com.google.gson.Gson
import java.util.*
import com.google.gson.reflect.TypeToken


//https://medium.com/@amit.bhandari/storing-java-objects-other-than-primitive-types-in-room-database-11e45f4f6d22
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun youTubeUrlSettingsToString(settings: YouTubeUrlSettings?):String?{
        val gson = Gson()
        return if(settings == null) null else gson.toJson(settings)
    }

    @TypeConverter
    fun fromYoutubeUrlSettingsString(value:String?):YouTubeUrlSettings?{
        val gson = Gson()
        return if(value == null) null else gson.fromJson(value, YouTubeUrlSettings::class.java)
    }
}