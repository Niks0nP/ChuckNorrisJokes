package com.example.chucknorrisjokes.data.network

import android.util.Log
import com.example.chucknorrisjokes.data.model.JokeEntity
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class HttpConnector {

    suspend fun getResponse(): JokeEntity? {
        val httpUrlConnector = createUrlConnector(Common.BASE_URL)

        try {
            val responseCode = httpUrlConnector.responseCode
            if (responseCode == HttpURLConnection.HTTP_OK) {
                val response = httpUrlConnector.inputStream.bufferedReader()
                    .use { it.readText() }
                    println(response)
                val parseResponse = ParserJson().parseJson(JSONObject(response))
                return parseResponse
            }
        } catch (e: Exception) {
            Log.d("TAG", "Error during data transfer: $e")
        }

        return null
    }

    private fun createUrlConnector(baseUrl: String) : HttpURLConnection {
        val url = URL(baseUrl)
        val httpURLConnection = url.openConnection() as HttpURLConnection

        httpURLConnection.setRequestProperty("Accept", "application/json")
        httpURLConnection.requestMethod = "GET"
        httpURLConnection.doInput = true
        httpURLConnection.doOutput = false

        return httpURLConnection
    }
}

object Common {
    const val BASE_URL = "https://api.chucknorris.io/jokes/random"
}