package com.example.android.youtubeurlmaker.data.source.remote.retrofit.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Murodjon on 2020.03.11
 */
data class ResetRequest(
    @field:SerializedName("email")
    val email:String
)