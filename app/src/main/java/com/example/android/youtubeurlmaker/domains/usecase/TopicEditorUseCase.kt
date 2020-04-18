package com.example.android.youtubeurlmaker.domains.usecase

import androidx.lifecycle.LiveData
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

/**
 * Created by murodjon on 2020/04/15
 */
interface TopicEditorUseCase {
    suspend fun deleteTopic(topic: Topic)

    suspend fun addQuestion(question: Question)

    suspend fun deleteQuestion(question: Question)

    suspend fun editQuestion(question:Question)

    suspend fun getQuestions(topic: Topic):LiveData<List<Question>>

    suspend fun addCategory(category: Category)

    suspend fun deleteCategory(category: Category)

    suspend fun getCategories():LiveData<List<Category>>
}