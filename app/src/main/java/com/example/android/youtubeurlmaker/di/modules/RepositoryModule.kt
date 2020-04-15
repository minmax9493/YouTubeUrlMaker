package com.example.android.youtubeurlmaker.di.modules

import com.example.android.youtubeurlmaker.domains.repository.TopicRepository
import com.example.android.youtubeurlmaker.domains.repository.impl.TopicRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by murodjon on 2020/04/15
 */
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideCustomerRepository(topicRepository: TopicRepositoryImpl): TopicRepository
}