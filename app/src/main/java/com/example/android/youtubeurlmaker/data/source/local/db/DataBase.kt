package com.example.android.youtubeurlmaker.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android.youtubeurlmaker.data.source.local.converter.DateConverter
import com.example.android.youtubeurlmaker.data.source.local.dao.CategoryDao
import com.example.android.youtubeurlmaker.data.source.local.dao.QuestionDao
import com.example.android.youtubeurlmaker.data.source.local.dao.TopicDao
import com.example.android.youtubeurlmaker.data.source.local.entity.Category
import com.example.android.youtubeurlmaker.data.source.local.entity.Question
import com.example.android.youtubeurlmaker.data.source.local.entity.Topic

/**
 * Created by murodjon on 2020/04/13
 */
@Database(entities = [
    Topic::class,
    Question::class,
    Category::class],
    version = 3,
    exportSchema = false)
@TypeConverters(DateConverter::class)
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
                ).fallbackToDestructiveMigration()//.addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Create the new table
                database.execSQL("CREATE TABLE topic_table1 (id LONG, name TEXT, url TEXT, status TEXT, created_at LONG, PRIMARY KEY(id))")
                // Remove the old table
                database.execSQL("DROP TABLE topic_table")
                // Change the table name to the correct one
                database.execSQL("ALTER TABLE topic_table1 RENAME TO topic_table")

                database.execSQL("ALTER TABLE question_table ADD COLUMN createdAt Date")
                database.execSQL("ALTER TABLE category_table ADD COLUMN createdAt Date")
            }
        }
    }
}