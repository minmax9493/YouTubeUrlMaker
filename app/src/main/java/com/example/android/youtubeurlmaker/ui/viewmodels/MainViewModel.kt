package com.example.android.youtubeurlmaker.ui.viewmodels

import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

/**
 * Created by murodjon on 2020/04/15
 */
interface MainViewModel{
    fun addTopic(url: String, title:String)
}