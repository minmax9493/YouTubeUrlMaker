package com.example.android.youtubeurlmaker.domains.usecase

import androidx.lifecycle.LiveData
import com.example.android.youtubeurlmaker.data.source.local.entity.Question

/**
 * Created by murodjon on 2020/04/18
 */
interface QuestionUseCase {
    fun getQuestions():LiveData<List<Question>>
}