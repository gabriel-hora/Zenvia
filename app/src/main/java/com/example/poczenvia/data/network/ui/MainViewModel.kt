package com.example.poczenvia.data.network.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.poczenvia.data.network.repository.RepositoryCall
import com.example.poczenvia.data.network.response.OriginResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: RepositoryCall) : ViewModel() {

    var call: MutableLiveData<Response<OriginResponse>> = MutableLiveData()

    fun pushCallFast(
        tipo: String,
        idRamal: Int,
        ramal: String,
        ligarPara: String,
        fecharFim: Boolean
    ) {
        viewModelScope.launch {
            val response = repository.callFast(tipo, idRamal, ramal, ligarPara, fecharFim)
            call.value = response
        }
    }
}