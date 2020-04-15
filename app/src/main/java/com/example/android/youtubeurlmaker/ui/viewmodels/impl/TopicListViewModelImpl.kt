package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.domains.usecase.TopicListUseCase
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by murodjon on 2020/04/14
 */
class TopicListViewModelImpl @Inject constructor(private val topicListUseCase: TopicListUseCase) : ViewModel(), TopicListViewModel {
    private val _openEditorLiveData = MutableLiveData<Unit>()
    private val _topicsLiveData = MutableLiveData<List<Topic>>()

    override val openEditorLiveData: LiveData<Unit>
        get() = _openEditorLiveData

    override val topicsLiveData: LiveData<List<Topic>> = topicListUseCase.getTopics()

    override fun openTopicEditor() {

    }

    override fun addTopic(url: String, title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val topic = Topic()
            topic.name = title
            topic.url = url
            topic.status = "Not Complete"

            topicListUseCase.addTopic(topic)

            Log.e("TopicList", "topic: $topic")
        }
    }

}