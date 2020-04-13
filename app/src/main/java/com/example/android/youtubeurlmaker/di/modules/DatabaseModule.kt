package com.example.android.youtubeurlmaker.di.modules

import android.content.Context
import com.example.android.youtubeurlmaker.data.source.local.db.DataBase
import dagger.Module
import dagger.Provides
import uz.minmax.sampledaggerapp.data.source.local.dao.TopicDao
import javax.inject.Singleton

/**
 * Created by Murodjon on 2020.03.11
 */
@Module
class RoomDBModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context) = DataBase.getDatabase(context)

    @Singleton
    @Provides
    fun provideCustomerDao(appDataBase: DataBase): TopicDao = appDataBase.topicDao()
}