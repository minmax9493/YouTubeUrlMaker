package com.example.android.youtubeurlmaker.di.modules.activity

import androidx.lifecycle.ViewModelProvider
import com.example.android.youtubeurlmaker.di.scopes.ActivityScope
import com.example.android.youtubeurlmaker.di.util.ViewModelFactory
import com.example.android.youtubeurlmaker.ui.viewmodels.MainViewModel
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.MainViewModelImpl
import dagger.Binds
import dagger.Module

/**
 * Created by murodjon on 2020/04/15
 */
@Module
interface ViewModelModule {

    @ActivityScope
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @ActivityScope
    @Binds
    fun getAppViewModel(mainViewModel: MainViewModelImpl): MainViewModel
}