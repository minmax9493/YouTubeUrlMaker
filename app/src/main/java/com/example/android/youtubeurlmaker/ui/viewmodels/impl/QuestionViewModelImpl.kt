package com.example.android.youtubeurlmaker.ui.viewmodels.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.domains.usecase.QuestionUseCase
import com.example.android.youtubeurlmaker.ui.viewmodels.QuestionViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by murodjon on 2020/04/18
 */
class QuestionViewModelImpl @Inject constructor(private val questionUseCase:QuestionUseCase):ViewModel(),QuestionViewModel {

    override val questionsLiveData: LiveData<List<Question>>
        get() = questionUseCase.getQuestions()

    override fun deleteQuestion(question: Question) {
        viewModelScope.launch(Dispatchers.IO) {
            questionUseCase.deleteQuestion(question)
        }
    }
}