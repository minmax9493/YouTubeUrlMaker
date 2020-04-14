package com.example.android.youtubeurlmaker.ui.viewmodels

import androidx.lifecycle.LiveData
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question

/**
 * Created by murodjon on 2020/04/14
 */
interface TopicEditorViewModel {
    val categoriesLiveData:LiveData<List<Category>>
    val questionsLiveData:LiveData<List<Question>>

    fun addNewCategory()
    fun addQuestion()
    fun deleteQuestion()
    fun editQuestion()
}