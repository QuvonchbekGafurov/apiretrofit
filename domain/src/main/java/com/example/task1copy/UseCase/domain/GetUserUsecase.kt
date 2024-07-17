package com.example.task1copy.UseCase.domain

import com.example.task1copy.UseCase.domain.model.UsersData
import retrofit2.Response


interface GetUserUsecase {
  suspend fun execute() :Response<UsersData>
}