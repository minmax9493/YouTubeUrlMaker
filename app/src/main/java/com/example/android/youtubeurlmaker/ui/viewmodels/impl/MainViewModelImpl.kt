package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.domains.usecase.AddTopicUseCase
import com.example.android.youtubeurlmaker.ui.viewmodels.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by murodjon on 2020/04/15
 */
class MainViewModelImpl @Inject constructor(private val topicUseCase: AddTopicUseCase) : ViewModel(), MainViewModel{

    override fun addTopic(url: String, title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val topic = Topic()
            topic.name = title
            topic.url = url
            topic.status = "Not Complete"

            topicUseCase.addTopic(topic)

            Log.e("TopicList", "topic: $topic")
        }
    }
}