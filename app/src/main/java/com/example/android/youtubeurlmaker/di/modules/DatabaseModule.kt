package com.example.android.youtubeurlmaker.di.modules

import android.content.Context
import com.example.android.youtubeurlmaker.data.source.local.dao.CategoryDao
import com.example.android.youtubeurlmaker.data.source.local.dao.QuestionDao
import com.example.android.youtubeurlmaker.data.source.local.dao.TopicDao
import com.example.android.youtubeurlmaker.data.source.local.db.DataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Murodjon on 2020.03.11
 */
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context) = DataBase.getDatabase(context)

    @Singleton
    @Provides
    fun provideTopicDao(appDataBase: DataBase): TopicDao = appDataBase.topicDao()

    @Singleton
    @Provides
    fun provideQuestionDao(appDataBase: DataBase):QuestionDao = appDataBase.questionDao()

    @Singleton
    @Provides
    fun provideCategoryDao(appDataBase: DataBase): CategoryDao = appDataBase.categoryDao()
}