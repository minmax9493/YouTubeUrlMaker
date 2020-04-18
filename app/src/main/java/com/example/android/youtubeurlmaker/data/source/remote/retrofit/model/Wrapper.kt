package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Murodjon on 2020.03.11
 */
data class Wrapper<T>(
    @field:SerializedName("data")
    val data:T? = null,

    @field:SerializedName("msgCode")
    val msgCode:String?=null
)