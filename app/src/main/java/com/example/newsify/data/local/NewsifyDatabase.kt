package com.example.newsify.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsify.domain.model.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(NewsifyTypeConverter::class)
abstract class NewsifyDatabase : RoomDatabase() {

    abstract val newsifyDao: NewsifyDao

}