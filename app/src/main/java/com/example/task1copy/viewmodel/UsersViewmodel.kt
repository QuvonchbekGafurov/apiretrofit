package com.example.task1copy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1copy.model.UsersData
import com.example.task1copy.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    private val _resp= MutableLiveData<UsersData>()
    val usersResp: LiveData<UsersData>
        get() = _resp

    init {
        GetUsers()
    }
    private fun GetUsers()=viewModelScope.launch {
        repository.GetUsers().let{response ->
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