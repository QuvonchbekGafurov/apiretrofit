package com.example.task1copy.UseCase.domain

import com.example.task1copy.UseCase.domain.model.UsersData
import retrofit2.Response

class GetUserUsecase (private val repository: Repository){
  suspend fun execute() :Response<UsersData>{
       return repository.GetUsers()
  }
}