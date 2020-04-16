package com.example.android.youtubeurlmaker.di.modules.activity

import com.example.android.youtubeurlmaker.di.scopes.ActivityScope
import com.example.android.youtubeurlmaker.domains.repository.TopicRepository
import com.example.android.youtubeurlmaker.domains.usecase.AddTopicUseCase
import dagger.Binds
import dagger.Module

@Module
interface UseCaseModule {

    @Binds
    @ActivityScope
    fun getAddTopicUseCase(repository: TopicRepository):AddTopicUseCase
}
