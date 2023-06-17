package com.example.a30daysfilms.data.remote

import retrofit2.http.GET
import retrofit2.http.Query


interface FilmsApi {
    @GET("movie/popular")
    suspend fun getFilms(@Query("page") page: Int):ApiResult

    companion object{
        const val BASE_URL="https://api.themoviedb.org/3/"
        const val AUT_TOKEN="Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiMTg5MTdiN2UwMTRkMjAxZmM1ZjM1NTk0NTZjYTA1ZSIsInN1YiI6IjY0ODM4MWM5ZTI3MjYwMDEwNzIxOWMyNiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.GysFeAA_cZcuKinvL3lxI5IG3bgFkzboDBdHbkIRSAA"
        const val IMG_URL="https://image.tmdb.org/t/p/w500/"
       }

}