package com.example.newsify.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Article (
    @ColumnInfo val author: String,
    @ColumnInfo val content: String,
    @ColumnInfo val description: String,
    @ColumnInfo val publishedAt: String,
    @ColumnInfo val source: Source,
    @ColumnInfo val title: String,
    @PrimaryKey val url: String,
    @ColumnInfo val urlToImage: String
) : Parcelable