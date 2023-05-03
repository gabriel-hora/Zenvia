package com.example.poczenvia.data.network

import androidx.lifecycle.ViewModel
import com.example.poczenvia.data.network.ui.MainViewModel
import com.example.poczenvia.data.network.repository.RepositoryCall

@Suppress("UNCHECKED_CAST")
class ViewModelProvider(private var repositoryCall: RepositoryCall) :
    androidx.lifecycle.ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repositoryCall) as T
        }
        throw java.lang.IllegalArgumentException("ViewModel class not found")
    }
}