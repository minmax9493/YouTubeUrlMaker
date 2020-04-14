package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.ui.viewmodels.TopicEditorViewModel

/**
 * Created by murodjon on 2020/04/14
 */
class TopicEditorViewModelImpl : ViewModel(), TopicEditorViewModel {


    override val categoriesLiveData: LiveData<List<Category>>
        get() = TODO("Not yet implemented")
    override val questionsLiveData: LiveData<List<Question>>
        get() = TODO("Not yet implemented")

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