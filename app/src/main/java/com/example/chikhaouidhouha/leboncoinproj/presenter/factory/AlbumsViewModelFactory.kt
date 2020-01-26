package com.example.chikhaouidhouha.leboncoinproj.presenter.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chikhaouidhouha.leboncoinproj.presenter.viewmodel.AlbumsViewModel

@Suppress("UNCHECKED_CAST")
class AlbumsViewModelFactory() : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumsViewModel() as T
    }
}