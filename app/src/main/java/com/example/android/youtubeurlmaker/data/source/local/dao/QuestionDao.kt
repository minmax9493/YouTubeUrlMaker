package com.example.android.youtubeurlmaker.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.youtubeurlmaker.data.source.local.entity.Question

/**
 * Created by murodjon on 2020/04/13
 */
@Dao
interface QuestionDao: BaseDao<Question> {

    @Query("select * from question_table order by name ASC")
    fun getQuestions(): LiveData<List<Question>>

    @Insert
    fun insertAll(questions:List<Question>)

}