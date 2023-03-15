package com.example.poczenvia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poczenvia.data.network.repository.RepositoryCall
import com.example.poczenvia.data.network.response.OriginRequest
import com.example.poczenvia.data.network.response.OriginResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: RepositoryCall) : ViewModel() {

    var call: MutableLiveData<Response<OriginResponse>> = MutableLiveData()

    fun pushCallFast(callBody: OriginRequest) {
        viewModelScope.launch {
            val response = repository.callFast(callBody)
            call.value = response
        }
    }
}