package com.example.android.youtubeurlmaker.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by murodjon on 2020/04/13
 */
@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @ColumnInfo(name = "id")
    var id:Long=0,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name:String=""
): Serializable