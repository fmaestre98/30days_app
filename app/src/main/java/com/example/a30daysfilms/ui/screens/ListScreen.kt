package com.example.a30daysfilms.ui.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.a30daysfilms.R
import com.example.a30daysfilms.data.remote.FilmsApi
import com.example.a30daysfilms.domain.Film

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    films: LazyPagingItems<Film>,
    onitemClick: (Film) -> Unit = {}
) {

    val context = LocalContext.current

    LaunchedEffect(key1 = films.loadState) {
        if (films.loadState.refresh is LoadState.Error) {
            Toast.makeText(
                context,
                "Error: " + (films.loadState.refresh as LoadState.Error).error.message,
                Toast.LENGTH_LONG
            )
        }
    }

    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        if (films.loadState.refresh is LoadState.Loading) {
            LoadingScreen()
        } else {
            // Fade in entry animation for the entire list
            AnimatedVisibility(
                visibleState = visibleState,
                enter = fadeIn(
                    animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
                ),
                exit = fadeOut(),
                modifier = modifier
            ) {
                LazyColumn() {
                    itemsIndexed(films) { index, film ->
                        FilmItem(
                            film = film!!, modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .animateEnterExit(
                                    enter = slideInVertically(
                                        animationSpec = spring(
                                            stiffness = Spring.StiffnessVeryLow,
                                            dampingRatio = Spring.DampingRatioLowBouncy
                                        ),
                                        initialOffsetY = { it * (index + 1) } // staggered entrance
                                    )
                                )
                                .clickable { onitemClick(film) }
                        )
                    }
                    item {
                        if (films.loadState.append is LoadState.Loading) {
                           Row(modifier= Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                              // CircularProgressIndicator()
                           }

                        }
                    }
                }
            }
        }
    }
}


@Composable
fun FilmItem(film: Film, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .height(200.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(FilmsApi.IMG_URL+film.poster_path)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.image_description),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier.weight(3f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = film.title,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 16.dp),
                    text = film.overview.take(120) + "..."
                )
            }

        }


    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
    }
}

