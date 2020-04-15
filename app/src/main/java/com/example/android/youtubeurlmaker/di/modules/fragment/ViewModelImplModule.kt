package com.example.android.youtubeurlmaker.di.modules.fragment

import com.example.android.youtubeurlmaker.di.scopes.FragmentScope
import com.example.android.youtubeurlmaker.di.util.ViewModelKey
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.SplashViewModelImpl
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.TopicEditorViewModelImpl
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.TopicListViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by murodjon on 2020/04/15
 */
@Module
interface ViewModelImplModule {
    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModelImpl::class)
    fun splashViewModelImpl(impl: SplashViewModelImpl): SplashViewModelImpl

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(TopicListViewModelImpl::class)
    fun topicListViewModelImpl(impl: TopicListViewModelImpl):TopicListViewModelImpl

    @FragmentScope
    @Binds
    @IntoMap
    @ViewModelKey(TopicEditorViewModelImpl::class)
    fun topicEditorViewModelImpl(impl: TopicEditorViewModelImpl):TopicEditorViewModelImpl
}