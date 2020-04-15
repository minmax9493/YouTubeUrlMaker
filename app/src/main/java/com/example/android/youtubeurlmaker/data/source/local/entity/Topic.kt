package com.example.android.youtubeurlmaker.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by murodjon on 2020/04/13
 */
@Entity(tableName = "topic_table")
data class Topic(
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

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    var createdAt:String?=null,

    @ColumnInfo(name = "status")
    @SerializedName("status")
    var status:String=""
): Serializable