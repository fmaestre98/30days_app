package com.example.a30daysfilms.ui.screens

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysfilms.R
import com.example.a30daysfilms.data.Film
import com.example.a30daysfilms.data.FilmsRepository
import com.example.a30daysfilms.ui.theme.DaysFilmsTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ListScreen(modifier: Modifier = Modifier, films: List<Film>) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }

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
                    film = film, modifier = Modifier
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
                )
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

            Image(
                painter = painterResource(id = film.image),
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = film.title,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(4.dp)
                )
                Text(
                    modifier = Modifier.padding(horizontal = 6.dp, vertical = 16.dp),
                    text = film.description.take(120) + "..."
                )
            }

        }


    }
}


@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    DaysFilmsTheme {
        FilmItem(
            film = Film(
                title = "Bigger",
                image = R.drawable.bigger,
                description = "La historia de los hermanos Joe y Ben Weider, quienes superaron el antisemitismo, los prejuicios sociales y la pobreza para fundar algo más que un negocio, una disciplina: el fisiculturismo moderno. Ellos descubrieron a Arnold Schwarzenegger.",
                releaseDate = "12 de octubre de 2018",
                language = "English",
                director = "George Gallo",
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ListPreview() {
    DaysFilmsTheme {
        ListScreen(modifier = Modifier, FilmsRepository.films)
    }
}