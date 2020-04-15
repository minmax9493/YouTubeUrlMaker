package com.example.android.youtubeurlmaker.di.modules.fragment

import com.example.android.youtubeurlmaker.di.scopes.FragmentScope
import com.example.android.youtubeurlmaker.ui.screens.SplashScreen
import com.example.android.youtubeurlmaker.ui.screens.TopicEditorScreen
import com.example.android.youtubeurlmaker.ui.screens.TopicListScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by murodjon on 2020/04/15
 */
@Module
interface FragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class, ViewModelImplModule::class, UseCaseModule::class])
    fun contributeSplashScreen():SplashScreen

    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class, ViewModelImplModule::class, UseCaseModule::class])
    fun contributeTopicListScreen():TopicListScreen

    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class, ViewModelImplModule::class, UseCaseModule::class])
    fun contributeTopicEditorScreen():TopicEditorScreen
}