package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.domains.usecase.QuestionUseCase
import com.example.android.youtubeurlmaker.ui.viewmodels.QuestionViewModel
import javax.inject.Inject

/**
 * Created by murodjon on 2020/04/18
 */
class QuestionViewModelImpl @Inject constructor(private val questionUseCase:QuestionUseCase):ViewModel(),QuestionViewModel {

    override val questionsLiveData: LiveData<List<Question>>
        get() = questionUseCase.getQuestions()
}