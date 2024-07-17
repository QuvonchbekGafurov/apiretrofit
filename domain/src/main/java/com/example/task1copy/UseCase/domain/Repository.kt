package com.example.task1copy.UseCase.domain

import com.example.task1copy.UseCase.domain.model.UsersData
import retrofit2.Response

interface Repository {
   suspend fun GetUsers():Response<UsersData>
}