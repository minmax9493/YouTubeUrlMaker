package com.example.android.youtubeurlmaker.util

import org.json.JSONObject
import java.net.URL


object SimpleYouTubeHelper {

 fun getTitleQuietly(youtubeUrl:String?):String? {
    try
    {
        if (youtubeUrl != null)
        {
            val embededURL = URL("http://www.youtube.com/oembed?url=" + youtubeUrl + "&format=json")
            return ""//JSONObject(IOUtils.toString(embededURL)).getString("title")
        }
    }
    catch (e:Exception) {
        e.printStackTrace()
    }
    return null
    }
}