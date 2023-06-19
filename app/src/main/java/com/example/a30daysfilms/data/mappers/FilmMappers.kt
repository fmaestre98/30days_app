package com.example.a30daysfilms.data.mappers

import com.example.a30daysfilms.data.local.FilmEntity
import com.example.a30daysfilms.data.remote.FilmDTO
import com.example.a30daysfilms.domain.Film

fun FilmDTO.toFilmEntity(index: Int): FilmEntity {

    return FilmEntity(
        id = index,
        idApi = id,
        adult = adult,
        backdropPath = backdrop_path,
        genreIds = genre_ids.joinToString(separator = ","),
        originalLanguage = original_language,
        originalTitle = original_title,
        overview = overview,
        popularity = popularity,
        posterPath = poster_path,
        releaseDate = release_date,
        title = title,
        voteAverage = vote_average,
        voteCount = vote_count
    )

}

fun FilmEntity.toFilm(): Film {

    return Film(
        id = id,
        idApi = idApi,
        adult = adult,
        backdrop_path = backdropPath,
        genre_ids = genreIds.split(",").toList().map { it.toInt() },
        original_language = originalLanguage,
        original_title = originalTitle,
        overview = overview,
        popularity = popularity,
        poster_path = posterPath,
        release_date = releaseDate,
        title = title,
        vote_average = voteAverage,
        vote_count = voteCount
    )

}