package com.example.android.youtubeurlmaker.di.modules.fragment

import com.example.android.youtubeurlmaker.di.scopes.FragmentScope
import com.example.android.youtubeurlmaker.domains.repository.TopicRepository
import com.example.android.youtubeurlmaker.domains.usecase.QuestionUseCase
import com.example.android.youtubeurlmaker.domains.usecase.TopicEditorUseCase
import com.example.android.youtubeurlmaker.domains.usecase.TopicListUseCase
import dagger.Binds
import dagger.Module

/**
 * Created by murodjon on 2020/04/15
 */
@Module
interface UseCaseModule{
    @FragmentScope
    @Binds
    fun getTopicListUseCase(repository: TopicRepository): TopicListUseCase

    @FragmentScope
    @Binds
    fun getTopicEditorUseCase(repository: TopicRepository):TopicEditorUseCase

    @FragmentScope
    @Binds
    fun getQuestionUseCase(repository: TopicRepository):QuestionUseCase
}