package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.domains.usecase.TopicListUseCase
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

/**
 * Created by murodjon on 2020/04/14
 */
class TopicListViewModelImpl @Inject constructor(private val topicListUseCase: TopicListUseCase) : ViewModel(), TopicListViewModel {
    override val topicsLiveData: LiveData<List<Topic>> = topicListUseCase.getTopics()

    override fun addTopic(url: String, title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val topic = Topic()
            topic.name = title
            topic.url = url
            topic.status = "Not Complete"
            topic.createdAt = Date()

            topicListUseCase.addTopic(topic)
        }
    }

    override fun deleteTopic(topic: Topic) {
        viewModelScope.launch(Dispatchers.IO) {
            topicListUseCase.deleteTopic(topic)
        }
    }

}