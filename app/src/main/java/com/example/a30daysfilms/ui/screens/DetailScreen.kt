package com.example.a30daysfilms.ui.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.a30daysfilms.R
import com.example.a30daysfilms.data.remote.FilmsApi
import com.example.a30daysfilms.domain.Film
import com.example.a30daysfilms.ui.theme.DaysFilmsTheme

@Composable
fun DetailScreen(modifier: Modifier = Modifier, film: Film) {
    val scrollState: ScrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(FilmsApi.IMG_URL + film.poster_path)
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.image_description),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .scrollable(scrollState, orientation = Orientation.Vertical),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = film.title,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 36.sp

            )
            Text(
                text = film.overview,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = "Adult: " + film.adult,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = "Language: " + film.original_language,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = "Popularity: " + film.popularity,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = film.release_date,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )

        }


    }


}

