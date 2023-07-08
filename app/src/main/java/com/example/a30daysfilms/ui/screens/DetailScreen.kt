package com.example.a30daysfilms.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(modifier: Modifier = Modifier, state: FilmViewModel.FilmsState) {
    val film: Film? = state.selectedFilm
    val scrollState: ScrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (state.loadingImages) {
                CircularProgressIndicator()
            } else if (state.imagesList?.isEmpty() == false) {

                val pagerState = rememberPagerState()
                val scope = rememberCoroutineScope()
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(330.dp)
                ) {
                    HorizontalPager(
                        pageCount = state.imagesList.size,
                        state = pagerState,
                        key = { state.imagesList[it].file_path }) {
                        Card(
                            elevation = CardDefaults.cardElevation(8.dp),
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier
                                .height(250.dp)
                                .width(200.dp)
                        ) {
                            AsyncImage(
                                model = ImageRequest.Builder(context = LocalContext.current)
                                    .data(FilmsApi.IMG_URL + state.imagesList[it].file_path)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = stringResource(R.string.image_description),
                                error = painterResource(R.drawable.ic_broken_image),
                                placeholder = painterResource(R.drawable.loading_img),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    IconButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        },
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.CenterEnd)
                            .width(40.dp)
                            .height(40.dp)
                            .clip(
                                CircleShape
                            ),
                        colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.right_arrow_svgrepo_com),
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                    IconButton(
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        },
                        modifier = Modifier
                            .padding(15.dp)
                            .align(Alignment.CenterStart)
                            .width(40.dp)
                            .height(40.dp)
                            .clip(
                                CircleShape
                            ),
                        colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.left_direction_arrow),
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }


            }

        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .scrollable(scrollState, orientation = Orientation.Vertical),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = film?.title ?: "",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth(),
                fontSize = 36.sp

            )
            Text(
                text = film?.overview ?: "",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = "Adult: " + film?.adult ?: "",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = "Language: " + film?.original_language,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = "Popularity: " + film?.popularity,
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )
            Text(
                text = film?.release_date ?: "",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 20.sp
            )

        }


    }


}

