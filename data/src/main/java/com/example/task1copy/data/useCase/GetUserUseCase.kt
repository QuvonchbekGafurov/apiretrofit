package com.example.task1copy.data.useCase

import com.example.task1copy.UseCase.domain.GetUserUsecase
import com.example.task1copy.UseCase.domain.Repository
import com.example.task1copy.UseCase.domain.model.UsersData
import retrofit2.Response
import javax.inject.Inject

class GetUserUseCaseImple @Inject constructor(private val repository: Repository):GetUserUsecase {
    override suspend fun execute(): Response<UsersData> {
        return repository.GetUsers()
    }
}