package com.bor96dev.icerockgithubapp.di.modules

import com.bor96dev.icerockgithubapp.data.AppRepository
import com.bor96dev.icerockgithubapp.data.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAppRepository(appRepositoryImpl: AppRepositoryImpl): AppRepository
}