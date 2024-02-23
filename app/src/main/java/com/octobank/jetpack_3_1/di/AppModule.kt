package com.octobank.jetpack_3_1.di

import android.app.Application
import com.octobank.jetpack_3_1.data.manager.LocalUserManagerImpl
import com.octobank.jetpack_3_1.domain.manager.LocalUserManager
import com.octobank.jetpack_3_1.domain.usecases.AppEntryUseCases
import com.octobank.jetpack_3_1.domain.usecases.ReadAppEntry
import com.octobank.jetpack_3_1.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

}