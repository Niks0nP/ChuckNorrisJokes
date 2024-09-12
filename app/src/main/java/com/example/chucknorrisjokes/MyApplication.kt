package com.example.chucknorrisjokes

import android.app.Application
import com.example.chucknorrisjokes.data.repository.JokesRepository

class MyApplication : Application() {

    val jokesRepository = JokesRepository()
    companion object {
        private lateinit var instance: MyApplication

        fun getInstance() : MyApplication {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}