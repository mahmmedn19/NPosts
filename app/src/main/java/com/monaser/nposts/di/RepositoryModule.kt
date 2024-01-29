package com.monaser.nposts.di

import com.monaser.nposts.data.remote.network.ApiService
import com.monaser.nposts.data.repository.PostsRepositoryImp
import com.monaser.nposts.domain.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePrayerRepo(
        prayerService: ApiService,
    ): PostsRepository {
        return PostsRepositoryImp(prayerService)
    }
}