package com.example.android.youtubeurlmaker.app

import com.example.android.youtubeurlmaker.BuildConfig
import com.example.android.youtubeurlmaker.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Created by murodjon on 2020/04/13
 */
class App: DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<App> {
        return DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        lateinit var instance: App private set
    }

}