package com.example.a30daysfilms.data.remote

data class ApiResult(
    val page: Int,
    val results: List<FilmDTO>,
    val total_pages: Int,
    val total_results: Int
)