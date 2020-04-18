package com.example.android.youtubeurlmaker.ui.viewmodels

import androidx.lifecycle.LiveData
import com.example.android.youtubeurlmaker.data.source.local.entity.Question

/**
 * Created by murodjon on 2020/04/18
 */
interface QuestionViewModel {
    val questionsLiveData:LiveData<List<Question>>
}