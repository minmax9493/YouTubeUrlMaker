package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.domains.usecase.TopicEditorUseCase
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicEditorViewModel
import javax.inject.Inject

/**
 * Created by murodjon on 2020/04/14
 */
class TopicEditorViewModelImpl @Inject constructor(private val topicEditorUseCase: TopicEditorUseCase) : ViewModel(), TopicEditorViewModel {
    private val _categoriesLiveData = MutableLiveData<List<Category>>()
    private val _questionsLiveData = MutableLiveData<List<Question>>()

    override val categoriesLiveData: LiveData<List<Category>>
        get() = _categoriesLiveData
    override val questionsLiveData: LiveData<List<Question>>
        get() = _questionsLiveData

    override fun addNewCategory() {
        TODO("Not yet implemented")
    }

    override fun addQuestion() {
        TODO("Not yet implemented")
    }

    override fun deleteQuestion() {
        TODO("Not yet implemented")
    }

    override fun editQuestion() {
        TODO("Not yet implemented")
    }

}