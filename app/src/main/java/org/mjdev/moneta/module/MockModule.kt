package org.mjdev.moneta.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mjdev.moneta.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
class MockModule {

    @Provides
    fun provideIsMock() : Boolean {
        return BuildConfig.USE_MOCK
    }

}