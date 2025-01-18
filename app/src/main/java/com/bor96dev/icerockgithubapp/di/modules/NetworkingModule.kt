package com.bor96dev.icerockgithubapp.di.modules

import com.bor96dev.icerockgithubapp.data.network.Mapper
import com.bor96dev.icerockgithubapp.data.network.RepoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesRepoService(retrofit: Retrofit): RepoService {
        return retrofit.create(RepoService::class.java)
    }


}