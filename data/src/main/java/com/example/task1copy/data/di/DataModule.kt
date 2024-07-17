package com.example.task1copy.data.di

import com.example.task1copy.UseCase.domain.Repository
import com.example.task1copy.data.Repository.RepositoryImple
import com.example.task1copy.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providesRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    @Provides
    @Singleton
    fun provideMainRepository(apiService: ApiService): Repository {
        return RepositoryImple(apiService)
    }

}