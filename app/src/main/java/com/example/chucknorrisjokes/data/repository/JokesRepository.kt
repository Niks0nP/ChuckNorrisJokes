package com.example.chucknorrisjokes.data.repository

import com.example.chucknorrisjokes.data.model.JokeEntity
import com.example.chucknorrisjokes.data.network.HttpConnector

class JokesRepository {

    private val jokesList = mutableListOf<JokeEntity>()

    suspend fun makeRequestJoke(httpConnector: HttpConnector) {
        httpConnector.getResponse()?.let { jokesList.add(it) }
    }

    fun getJokes() : List<JokeEntity> {
        return jokesList
    }
}