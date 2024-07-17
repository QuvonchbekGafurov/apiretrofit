package com.example.task1copy.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1copy.UseCase.domain.GetUserUsecase
import com.example.task1copy.UseCase.domain.Repository
import com.example.task1copy.UseCase.domain.model.UsersData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val GetUsersUsecase: GetUserUsecase): ViewModel() {
    private val _resp= MutableLiveData<UsersData>()
    val usersResp: LiveData<UsersData>
        get() = _resp

    init {
        GetUsers()
    }
    private fun GetUsers()=viewModelScope.launch {
        GetUsersUsecase.execute()
            .let{response ->
            if (response.isSuccessful)
            {
                _resp.postValue(response.body())
            }
            else{
                Log.d("TAG", "GetUsers:${response.message()} ")
            }

        }
    }

}