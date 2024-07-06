package com.example.task1copy.repository

import com.example.task1copy.api.ApiService
import javax.inject.Inject

class Repository  @Inject constructor(private val apiServise:ApiService) {
        suspend fun GetUsers()=apiServise.GetUsers()
    }
