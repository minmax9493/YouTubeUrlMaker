package com.example.android.youtubeurlmaker.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.youtubeurlmaker.data.source.local.dao.BaseDao
import com.example.android.youtubeurlmaker.data.source.local.entity.Category

@Dao
interface CategoryDao: BaseDao<Category> {

    @Query("select * from category_table order by name ASC")
    fun getCategories(): LiveData<List<Category>>

    @Insert
    fun insertAll(categories:List<Category>)

}