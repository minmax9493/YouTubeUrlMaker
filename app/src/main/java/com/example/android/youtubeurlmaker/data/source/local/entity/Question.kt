package com.example.android.youtubeurlmaker.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

/**
 * Created by murodjon on 2020/04/13
 */
@Entity(tableName = "question_table")
data class Question(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id:Long=0,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name:String="",

    @ColumnInfo(name = "url")
    @SerializedName("url")
    var url:String="",

    @ColumnInfo(name = "topicId")
    @SerializedName("topicId")
    var topicId:Long?=null,

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    var createdAt: Date?=null
): Serializable