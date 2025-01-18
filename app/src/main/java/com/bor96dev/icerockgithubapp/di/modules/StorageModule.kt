package com.bor96dev.icerockgithubapp.di.modules

import android.content.Context
import com.bor96dev.icerockgithubapp.data.KeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Provides
    @Singleton
    fun providesKeyValueStorage(@ApplicationContext context: Context) : KeyValueStorage {
        return KeyValueStorage(context)
    }


}