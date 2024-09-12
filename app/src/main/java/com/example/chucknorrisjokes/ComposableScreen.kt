package com.example.chucknorrisjokes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chucknorrisjokes.ui.theme.ChuckNorrisJokesTheme

class ComposableScreen {

    @Composable
    fun ScreenJoke(modifier: Modifier = Modifier) {
        Column(modifier.fillMaxSize()) {
            TopTitle(modifier)
            Spacer(modifier.padding(20.dp))
            ItemJoke(modifier)
        }

    }

    @Composable
    fun TopTitle(modifier: Modifier) {
        Column(modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Chuck Norris fact",
                modifier.padding(top = 16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp)
        }
    }

    @Composable
    fun ItemJoke(modifier: Modifier) {
        Row(modifier.fillMaxWidth()) {
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ChuckNorrisJokesTheme {
            ComposableScreen().ScreenJoke()
        }
    }
}