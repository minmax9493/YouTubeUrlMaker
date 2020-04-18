package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Murodjon on 2020.03.11
 */
data class LoginRequest(
    @field:SerializedName("email")
    val emial:String,

    @field:SerializedName("password")
    val password:String,

    @field:SerializedName("deviceId")
    val deviceId:String,

    @field:SerializedName("type")
    val type:String/*pivo*/
)