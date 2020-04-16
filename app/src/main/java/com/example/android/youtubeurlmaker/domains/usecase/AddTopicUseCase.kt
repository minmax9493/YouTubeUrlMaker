package com.example.android.youtubeurlmaker.domains.usecase

import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

/**
 * Created by murodjon on 2020/04/16
 */
interface AddTopicUseCase {
    suspend fun addTopic(topic:Topic)
}