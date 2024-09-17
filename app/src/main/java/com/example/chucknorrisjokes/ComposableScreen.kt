package com.example.chucknorrisjokes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.example.chucknorrisjokes.data.model.JokeEntity
import com.example.chucknorrisjokes.ui.theme.LightBlue
import com.example.chucknorrisjokes.viewmodel.JokeViewModel
import kotlinx.coroutines.launch

class ComposableScreen {

    @Composable
    fun ScreenJoke(modifier: Modifier = Modifier, viewModel: JokeViewModel, onJokeClicked: () -> Unit) {

        val jokeStateFlow by viewModel.stateFlow.collectAsState()
        var list = remember { viewModel.getJokeList() }

        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()

        ConstraintLayout {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp)
            ) {
                TopTitle()

                LaunchedEffect(jokeStateFlow) {
                    list = viewModel.getJokeList()
                    coroutineScope.launch {
                        listState.animateScrollToItem(list.size)
                    }
                }

                LazyColumn(state = listState) {
                    items(list.size) {
                        ItemJoke(list[it])
                    }
                }
            }
            Button(
                onClick = onJokeClicked,
                Modifier
                    .fillMaxWidth()
                    .constrainAs(createRef()) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
                Text("Add joke")
            }
        }
    }

    @Composable
    fun TopTitle() {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Chuck Norris fact",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp)
        }
    }

    @Composable
    fun ItemJoke(joke: JokeEntity?) {
        Row(Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
            .border(2.dp, Color.LightGray, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(LightBlue)

        ) {
            Image(
                painter = rememberImagePainter("https://api.chucknorris.io/img/avatar/chuck-norris.png"),
                contentDescription = "Todo",
                Modifier
                    .padding(start = 16.dp, top = 10.dp)
                    .size(50.dp)
            )
            Column {
                Text(
                    if (joke?.categories?.equals("[]") == true) "Category joke: random"
                    else "Category joke: ${joke?.categories}",
                    Modifier.padding(start = 16.dp, bottom = 10.dp, top = 10.dp),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
                Text(
                    joke?.value ?: "No found joke",
                    Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp)

                )
            }
        }
    }
}