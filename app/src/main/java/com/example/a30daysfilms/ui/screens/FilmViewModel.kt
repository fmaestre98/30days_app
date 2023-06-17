package com.example.a30daysfilms.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.a30daysfilms.data.local.FilmEntity
import com.example.a30daysfilms.data.mappers.toFilm
import com.example.a30daysfilms.domain.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    pager: Pager<Int, FilmEntity>,
) : ViewModel() {

    val filmPagerFlow =
        pager.flow.map { pagingData -> pagingData.map { it.toFilm() } }
            .cachedIn(viewModelScope)


    private val _state = MutableStateFlow(FilmsState())
    val state = _state.asStateFlow()


    fun selectFilm(film: Film): Unit {
        _state.update {
            it.copy(
                selectedFilm = film
            )
        }

    }

    fun removeSelectedFilm() {
        _state.update {
            it.copy(
                selectedFilm = null
            )
        }
    }

    data class FilmsState(
        val selectedFilm: Film? = null,
        val error: Boolean = false

    )
}