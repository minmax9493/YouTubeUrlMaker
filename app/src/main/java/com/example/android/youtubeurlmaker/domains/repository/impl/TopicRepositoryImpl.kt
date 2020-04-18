package com.example.android.youtubeurlmaker.domains.repository.impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.youtubeurlmaker.data.source.local.dao.CategoryDao
import com.example.android.youtubeurlmaker.data.source.local.dao.QuestionDao
import com.example.android.youtubeurlmaker.data.source.local.dao.TopicDao
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic
import com.example.android.youtubeurlmaker.domains.repository.TopicRepository
import dagger.Reusable
import javax.inject.Inject

/**
 * Created by murodjon on 2020/04/13
 */
@Reusable
class TopicRepositoryImpl @Inject constructor(private val topicDao: TopicDao,
                                              private val questionDao: QuestionDao,
                                              private val categoryDao: CategoryDao):TopicRepository {
    override suspend fun addTopic(topic: Topic) {
        val id =topicDao.insert(topic)
    }

    override fun getTopics(): LiveData<List<Topic>> {
        return topicDao.getTopics()
    }

    override suspend fun deleteTopic(topic: Topic) {
        topicDao.delete(topic)
    }

    override suspend fun addQuestion(question: Question) {
        questionDao.insert(question)
    }

    override suspend fun deleteQuestion(question: Question) {
        questionDao.delete(question)
    }

    override suspend fun editQuestion(question: Question) {
        questionDao.update(question)
    }

    override suspend fun getQuestions(topic: Topic): LiveData<List<Question>> {
        return questionDao.getQuestions()
    }

    override suspend fun addCategory(category: Category) {
        categoryDao.insert(category)
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.delete(category)
    }

    override suspend fun getCategories(): LiveData<List<Category>> {
        return categoryDao.getCategories()
    }
}