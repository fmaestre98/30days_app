package com.example.a30daysfilms.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.a30daysfilms.data.local.FilmEntity
import com.example.a30daysfilms.data.mappers.toFilm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
     pager: Pager<Int, FilmEntity>,
   ) : ViewModel() {

    val filmPagerFlow =
        pager.flow.map { pagingData -> pagingData.map { it.toFilm() } }
            .cachedIn(viewModelScope)




}