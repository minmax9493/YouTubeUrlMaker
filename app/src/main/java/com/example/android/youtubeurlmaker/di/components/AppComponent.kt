package com.example.android.youtubeurlmaker.di.components

import android.content.Context
import com.example.android.youtubeurlmaker.app.App
import com.example.android.youtubeurlmaker.di.modules.DatabaseModule
import com.example.android.youtubeurlmaker.di.modules.RepositoryModule
import com.example.android.youtubeurlmaker.di.modules.activity.ActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * Created by murodjon on 2020/04/13
 */
@Singleton
@Component(modules = [ActivityModule::class, DatabaseModule::class, RepositoryModule::class, AndroidInjectionModule::class])
interface AppComponent :AndroidInjector<App> {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context):AppComponent
    }
}