package com.example.chucknorrisjokes.data.repository

import com.example.chucknorrisjokes.data.model.JokeEntity
import com.example.chucknorrisjokes.data.network.HttpConnector

class JokesRepository {

    private var jokesList = mutableListOf<JokeEntity>()

    suspend fun makeRequestJoke(httpConnector: HttpConnector) : JokeEntity? {
        jokesList.add(httpConnector.getResponse()!!)
        return httpConnector.getResponse()
    }

    fun getJokes() : List<JokeEntity> {
        return jokesList
    }

    suspend fun updateJoke(httpConnector: HttpConnector) : JokeEntity? {
        jokesList.add(httpConnector.getResponse()!!)
        return httpConnector.getResponse()
    }
}