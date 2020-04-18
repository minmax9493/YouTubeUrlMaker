package com.example.android.youtubeurlmaker.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

@Dao
interface TopicDao: BaseDao<Topic> {

    @Query("select * from topic_table order by created_at DESC")
    fun getTopics(): LiveData<List<Topic>>

    @Insert
    fun insertAll(topics:List<Topic>)
}