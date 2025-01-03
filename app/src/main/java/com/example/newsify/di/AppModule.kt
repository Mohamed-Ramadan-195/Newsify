package com.example.newsify.di

import android.app.Application
import androidx.room.Room
import com.example.newsify.data.local.NewsifyDao
import com.example.newsify.data.local.NewsifyDatabase
import com.example.newsify.data.local.NewsifyTypeConverter
import com.example.newsify.data.manager.LocalUserManagerImpl
import com.example.newsify.data.remote.NewsifyApi
import com.example.newsify.data.repository.NewsifyRepositoryImpl
import com.example.newsify.domain.manager.LocalUserManager
import com.example.newsify.domain.repository.NewsifyRepository
import com.example.newsify.domain.usecase.app_entry.AppEntryUseCases
import com.example.newsify.domain.usecase.app_entry.ReadAppEntryUseCase
import com.example.newsify.domain.usecase.app_entry.SaveAppEntryUseCase
import com.example.newsify.domain.usecase.newsify.remote.GetNewsUseCase
import com.example.newsify.domain.usecase.newsify.NewsifyUseCases
import com.example.newsify.domain.usecase.newsify.local.DeleteNewsUseCase
import com.example.newsify.domain.usecase.newsify.local.InsertArticleUseCase
import com.example.newsify.domain.usecase.newsify.local.SelectArticleUseCase
import com.example.newsify.domain.usecase.newsify.local.SelectArticlesUseCase
import com.example.newsify.domain.usecase.newsify.remote.SearchNewsUseCase
import com.example.newsify.util.Constant.BASE_URL
import com.example.newsify.util.Constant.NEWSIFY_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager (
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases (
        localUserManager: LocalUserManager
    ) = AppEntryUseCases (
        saveAppEntryUseCase = SaveAppEntryUseCase(localUserManager = localUserManager),
        readAppEntryUseCase = ReadAppEntryUseCase(localUserManager = localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsifyUseCases (
        newsifyRepository: NewsifyRepository
    ) : NewsifyUseCases {
        return NewsifyUseCases (
            getNewsUseCase = GetNewsUseCase(newsifyRepository),
            searchNewsUseCase = SearchNewsUseCase(newsifyRepository),
            insertArticleUseCase = InsertArticleUseCase(newsifyRepository),
            deleteNewsUseCase = DeleteNewsUseCase(newsifyRepository),
            selectArticleUseCase = SelectArticleUseCase(newsifyRepository),
            selectArticlesUseCase = SelectArticlesUseCase(newsifyRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsifyApi(): NewsifyApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsifyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsifyRepository(
        newsifyApi: NewsifyApi,
        newsifyDao: NewsifyDao
    ) : NewsifyRepository = NewsifyRepositoryImpl(
        newsifyApi = newsifyApi,
        newsifyDao = newsifyDao
    )

    @Provides
    @Singleton
    fun provideNewsifyDatabase(
        application: Application
    ) : NewsifyDatabase {
        return Room.databaseBuilder (
            context = application,
            klass = NewsifyDatabase::class.java,
            name = NEWSIFY_DATABASE_NAME
        ).addTypeConverter(NewsifyTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsifyDao (newsifyDatabase: NewsifyDatabase) = newsifyDatabase.newsifyDao

}