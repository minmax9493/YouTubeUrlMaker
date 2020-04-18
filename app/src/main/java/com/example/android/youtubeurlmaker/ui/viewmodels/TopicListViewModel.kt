package com.example.android.youtubeurlmaker.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

/**
 * Created by murodjon on 2020/04/14
 */
interface TopicListViewModel {
    val openEditorLiveData:LiveData<Topic>
    val topicsLiveData:LiveData<List<Topic>>

    fun openTopicEditor(topic:Topic)
    fun addTopic(url:String, title:String)
}