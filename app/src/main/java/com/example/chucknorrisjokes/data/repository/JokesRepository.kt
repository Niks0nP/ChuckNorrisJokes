package com.example.chucknorrisjokes.data.repository

import com.example.chucknorrisjokes.data.model.JokeEntity
import com.example.chucknorrisjokes.data.network.HttpConnect

class JokesRepository(private val httpConnect: HttpConnect) {

    private val jokesList = mutableListOf<JokeEntity>()

    suspend fun requestJoke() {
        httpConnect.getResponse()
    }

    fun getJokes() : List<JokeEntity> {
        return jokesList
    }
}