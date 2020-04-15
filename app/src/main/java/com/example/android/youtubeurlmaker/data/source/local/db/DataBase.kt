package com.example.android.youtubeurlmaker.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.youtubeurlmaker.data.source.local.dao.CategoryDao
import com.example.android.youtubeurlmaker.data.source.local.dao.QuestionDao
import com.example.android.youtubeurlmaker.data.source.local.dao.TopicDao
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

/**
 * Created by murodjon on 2020/04/13
 */
@Database(entities = [Topic::class, Question::class, Category::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun topicDao(): TopicDao
    abstract fun questionDao():QuestionDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        private const val DB_NAME:String = "dagger_app_db"

        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    DataBase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}