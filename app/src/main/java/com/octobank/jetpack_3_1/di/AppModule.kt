package com.octobank.jetpack_3_1.di

import android.app.Application
import com.octobank.jetpack_3_1.data.NewsApi
import com.octobank.jetpack_3_1.data.NewsRepository
import com.octobank.jetpack_3_1.data.manager.LocalUserManagerImpl
import com.octobank.jetpack_3_1.data.repository.NewsRepositoryImpl
import com.octobank.jetpack_3_1.domain.manager.LocalUserManager
import com.octobank.jetpack_3_1.domain.usecases.app_entry.AppEntryUseCases
import com.octobank.jetpack_3_1.domain.usecases.app_entry.ReadAppEntry
import com.octobank.jetpack_3_1.domain.usecases.app_entry.SaveAppEntry
import com.octobank.jetpack_3_1.domain.usecases.news.GetNews
import com.octobank.jetpack_3_1.domain.usecases.news.NewsUseCases
import com.octobank.jetpack_3_1.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application,
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManager: LocalUserManager,
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager = localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager = localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(NewsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
    ): NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository,
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}