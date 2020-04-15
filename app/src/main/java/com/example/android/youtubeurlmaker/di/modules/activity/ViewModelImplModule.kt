package com.example.android.youtubeurlmaker.di.modules.activity

import com.example.android.youtubeurlmaker.di.scopes.ActivityScope
import com.example.android.youtubeurlmaker.di.util.ViewModelKey
import com.example.android.youtubeurlmaker.ui.viewmodels.MainViewModel
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.MainViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by murodjon on 2020/04/15
 */
@Module
interface ViewModelImplModule {

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModelImpl::class)
    fun getMainViewModel(viewModel:MainViewModelImpl):MainViewModel
}