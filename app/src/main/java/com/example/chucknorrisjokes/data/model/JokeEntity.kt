package com.example.chucknorrisjokes.data.model

import java.util.ArrayList

data class JokeEntity(
    val categories: ArrayList<String>?,
    val createdAt: String,
    val iconUrl: String,
    val id: String,
    val updatedAt: String?,
    val url: String?,
    val value: String?,
)
