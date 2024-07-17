package com.example.task1copy.data.Repository


import com.example.task1copy.UseCase.domain.Repository
import com.example.task1copy.UseCase.domain.model.UsersData
import com.example.task1copy.data.api.ApiService
import retrofit2.Response
import javax.inject.Inject

class RepositoryImple @Inject constructor(private val apiService: ApiService):Repository{
    override suspend fun GetUsers():Response<UsersData> {
        val user=apiService.GetUsers()
        return user
    }
}