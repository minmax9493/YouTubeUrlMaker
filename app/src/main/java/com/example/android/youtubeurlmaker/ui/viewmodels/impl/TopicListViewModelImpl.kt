package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicListViewModel

/**
 * Created by murodjon on 2020/04/14
 */
class TopicListViewModelImpl : ViewModel(), TopicListViewModel {
    private val _openEditorLiveData = MutableLiveData<Unit>()
    private val _topicsLiveData = MutableLiveData<List<Topic>>()

    override val openEditorLiveData: LiveData<Unit>
        get() = _openEditorLiveData
    override val topicsLiveData: LiveData<List<Topic>>
        get() = _topicsLiveData

    override fun openTopicEditor() {
        TODO("Not yet implemented")
    }

    override fun addTopic(url: String, title: String) {
        TODO("Not yet implemented")
    }

}