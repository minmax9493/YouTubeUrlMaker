package com.example.android.youtubeurlmaker.domains.repository

import com.example.android.youtubeurlmaker.domains.usecase.AddTopicUseCase
import com.example.android.youtubeurlmaker.domains.usecase.QuestionUseCase
import com.example.android.youtubeurlmaker.domains.usecase.TopicEditorUseCase
import com.example.android.youtubeurlmaker.domains.usecase.TopicListUseCase


/**
 * Created by murodjon on 2020/04/13
 */
interface TopicRepository:TopicListUseCase, TopicEditorUseCase, AddTopicUseCase, QuestionUseCase