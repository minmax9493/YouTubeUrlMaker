package com.example.android.youtubeurlmaker.di.modules.fragment

import com.example.android.youtubeurlmaker.di.scopes.FragmentScope
import com.example.android.youtubeurlmaker.ui.viewmodels.QuestionViewModel
import com.example.android.youtubeurlmaker.ui.viewmodels.SplashViewModel
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicEditorViewModel
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicListViewModel
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.QuestionViewModelImpl
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.SplashViewModelImpl
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.TopicEditorViewModelImpl
import com.example.android.youtubeurlmaker.ui.viewmodels.impl.TopicListViewModelImpl
import dagger.Binds
import dagger.Module

/**
 * Created by murodjon on 2020/04/15
 */
@Module
interface ViewModelModule {

    @FragmentScope
    @Binds
    fun getSplashViewModel(viewModel:SplashViewModelImpl):SplashViewModel

    @FragmentScope
    @Binds
    fun getTopicEditorViewModel(viewModel: TopicEditorViewModelImpl):TopicEditorViewModel

    @FragmentScope
    @Binds
    fun getTopicListViewModel(viewModelImpl: TopicListViewModelImpl):TopicListViewModel

    @FragmentScope
    @Binds
    fun getQuestionListViewModel(viewModelImpl: QuestionViewModelImpl):QuestionViewModel
}