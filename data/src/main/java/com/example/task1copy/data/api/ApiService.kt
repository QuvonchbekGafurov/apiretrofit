package com.example.task1copy.data.api

import com.example.task1copy.UseCase.domain.model.UsersData
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("users")
    suspend fun GetUsers():Response<UsersData>
}