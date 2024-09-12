package com.example.chucknorrisjokes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chucknorrisjokes.data.network.HttpConnector
import com.example.chucknorrisjokes.ui.theme.ChuckNorrisJokesTheme
import com.example.chucknorrisjokes.viewmodel.JokeViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val composableScreen = ComposableScreen()
    lateinit var jokeViewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        jokeViewModel = JokeViewModel()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChuckNorrisJokesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    composableScreen.ScreenJoke(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        jokeViewModel.getJoke()
//            GlobalScope.launch {
//                HttpConnector().getResponse()
//            }
//            HttpConnect().getResponse()

    }
}

