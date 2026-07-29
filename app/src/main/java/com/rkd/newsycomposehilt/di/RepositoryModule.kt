package com.rkd.newsycomposehilt.di

import com.rkd.newsycomposehilt.domain.repository.NewsRepository
import com.rkd.newsycomposehilt.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Binds
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        repositoryImpl: NewsRepositoryImpl
    ): NewsRepository
}