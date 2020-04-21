package com.example.android.youtubeurlmaker.data.source.local.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class YouTubeUrlSettings(
    @SerializedName("videoId")val videoId:String,
    @SerializedName("startTime") val startTime:Int=0,
    @SerializedName("endTime")var endTime: Int = -1
):Serializable