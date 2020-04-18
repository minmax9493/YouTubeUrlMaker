package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Murodjon at 2020.03.11
 */
data class RegistrationRequest(
    @field:SerializedName("email")
    val email:String,

    @field:SerializedName("password")
    val password:String,

    @field:SerializedName("deviceId")
    val deviceId:String,

    @field:SerializedName("firstName")
    val firstName:String,

    @field:SerializedName("lastName")
    val lastName: String
)