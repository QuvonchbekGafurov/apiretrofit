package com.example.task1copy.data.di

import com.example.task1copy.UseCase.domain.GetUserUsecase
import com.example.task1copy.UseCase.domain.Repository
import com.example.task1copy.data.Repository.RepositoryImple
import com.example.task1copy.data.useCase.GetUserUseCaseImple
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetUserUseCase(repository: Repository): GetUserUsecase {
        return GetUserUseCaseImple(repository)
    }}