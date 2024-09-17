package com.example.chucknorrisjokes

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.chucknorrisjokes.ui.theme.ChuckNorrisJokesTheme
import com.example.chucknorrisjokes.viewmodel.JokeViewModel

class MainActivity : ComponentActivity() {

    private val composableScreen = ComposableScreen()
    private lateinit var jokeViewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        jokeViewModel = JokeViewModel()

        enableEdgeToEdge(navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT))
        setContent {
            ChuckNorrisJokesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    composableScreen.ScreenJoke(
                        modifier = Modifier.padding(innerPadding),
                        jokeViewModel
                    ) { jokeViewModel.sendRequest() }
                }
            }
        }
    }
}

