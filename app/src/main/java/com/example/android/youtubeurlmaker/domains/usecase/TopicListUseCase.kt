package com.example.android.youtubeurlmaker.domains.usecase

import androidx.lifecycle.LiveData
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

/**
 * Created by murodjon on 2020/04/13
 */
interface TopicListUseCase {
    suspend fun addTopic(topic: Topic)
    fun getTopics():LiveData<List<Topic>>
}