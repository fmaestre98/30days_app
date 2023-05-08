package com.example.a30daysfilms.data

import androidx.annotation.DrawableRes

data class Film(
    val title: String,
    @DrawableRes val image: Int,
    val description: String,
    val director: String,
    val language:String,
    val releaseDate:String,
    val collection:String?=null
)
