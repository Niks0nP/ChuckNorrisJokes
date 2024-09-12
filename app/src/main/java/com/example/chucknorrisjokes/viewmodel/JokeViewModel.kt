package com.example.chucknorrisjokes.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisjokes.MyApplication
import com.example.chucknorrisjokes.data.network.HttpConnector
import com.example.chucknorrisjokes.data.repository.JokesRepository
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    val stateFlow = mutableIntStateOf(0)
    private val repository = MyApplication.getInstance().jokesRepository


    fun getJoke() {
        viewModelScope.launch {
            repository.makeRequestJoke(HttpConnector())
        }
    }
}