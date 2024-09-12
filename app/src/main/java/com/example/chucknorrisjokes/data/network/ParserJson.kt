package com.example.chucknorrisjokes.data.network

import com.example.chucknorrisjokes.data.model.JokeEntity
import org.json.JSONObject


/*
{"categories":[],
"created_at":"2020-01-05 13:42:21.179347",
"icon_url":"https://api.chucknorris.io/img/avatar/chuck-norris.png",
"id":"Qt_UW93qTDSWNCdsQG3bNQ",
"updated_at":"2020-01-05 13:42:21.179347",
"url":"https://api.chucknorris.io/jokes/Qt_UW93qTDSWNCdsQG3bNQ",
"value":"Chuck Norris can drown a fish."}
 */

class ParserJson {

    fun parseJson(jsonObject: JSONObject) : JokeEntity {

        val categoriesJsonArray = jsonObject.getJSONArray("categories")
        val categories = ArrayList<String>()
        for (i in 0 until categoriesJsonArray.length()) {
            categories.add(categoriesJsonArray.getString(i))
        }

        val jokeEntity = JokeEntity(
            categories = categories,
            createdAt = jsonObject.getString("created_at"),
            iconUrl = jsonObject.getString("icon_url"),
            id = jsonObject.getString("id"),
            updatedAt = jsonObject.optString("updated_at", null.toString()),
            url = jsonObject.optString("url", null.toString()),
            value = jsonObject.optString("value", null.toString())
        )

        return jokeEntity
    }

}