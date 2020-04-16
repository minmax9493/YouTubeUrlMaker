package com.example.android.youtubeurlmaker.di.modules.activity

import com.example.android.youtubeurlmaker.MainActivity
import com.example.android.youtubeurlmaker.di.modules.fragment.FragmentModule
import com.example.android.youtubeurlmaker.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by murodjon on 2020/04/15
 */
@Module
interface ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [FragmentModule::class, ViewModelImplModule::class, ViewModelModule::class, UseCaseModule::class])
    fun contributeMainActivity(): MainActivity
}