package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Murodjon at 2020.03.11
 */
sealed class LoginResponse {

    data class LoginData(
        @field:SerializedName("toekns")
        val token:Tokens?=null,

        @field:SerializedName("user")
        val user:User? = null
    )

    data class User(
        @field:SerializedName("userName")
        val userName:String? =null,

        @field:SerializedName("firstName")
        val firstName:String? = null,

        @field:SerializedName("lastName")
        val lastName:String? = null,

        @field:SerializedName("createdAt")
        val createdAt:String? = null
    )

    data class Tokens(
        @field:SerializedName("token")
        val token:String? = null,

        @field:SerializedName("accessToken")
        val accessToken:String? = null,

        @field:SerializedName("refreshToken")
        val refreshToken:String? = null
    )

}