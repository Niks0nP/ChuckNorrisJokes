package com.example.chucknorrisjokes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorrisjokes.MyApplication
import com.example.chucknorrisjokes.data.model.JokeEntity
import com.example.chucknorrisjokes.data.network.HttpConnector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JokeViewModel : ViewModel() {

    init {
        updateJokes()
    }

    private val _stateFlow = MutableStateFlow<JokeEntity?>(null)
    val stateFlow = _stateFlow.asStateFlow()

    private val repository = MyApplication.getInstance().jokesRepository


    fun sendRequest() {
        viewModelScope.launch(Dispatchers.IO) {
            _stateFlow.value = repository.makeRequestJoke(HttpConnector())
        }
    }

    fun getJokeList() : List<JokeEntity> {
        return repository.getJokes()
    }

    private fun updateJokes() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(5 * 60 * 1000) // 5 минут

            _stateFlow.value = repository.updateJoke(HttpConnector())
        }
    }
}