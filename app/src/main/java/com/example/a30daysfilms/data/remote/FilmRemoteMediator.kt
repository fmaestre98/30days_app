package com.example.a30daysfilms.data.remote

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import coil.network.HttpException
import com.example.a30daysfilms.data.local.FilmDatabase
import com.example.a30daysfilms.data.local.FilmEntity
import com.example.a30daysfilms.data.mappers.toFilmEntity
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class FilmRemoteMediator(private val filmDatabase: FilmDatabase, private val filmsApi: FilmsApi) :
    RemoteMediator<Int, FilmEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, FilmEntity>
    ): MediatorResult {
        var lastItem:FilmEntity?=null
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    lastItem = state.lastItemOrNull()
                    if (lastItem == null) {
                        1
                    } else {
                        (lastItem.id!! / state.config.pageSize) + 1

                    }

                }
            }

            val films = filmsApi.getFilms(loadKey)
            filmDatabase.withTransaction {
                val lastId:Int = lastItem?.id ?: 0
                if (loadType == LoadType.REFRESH) {
                    filmDatabase.filmDao.clearAll()
                }
               val filmEntityList = films.results.mapIndexed { index, filmDTO -> filmDTO.toFilmEntity(index+lastId+1) }
                filmDatabase.filmDao.upsertAll(filmEntityList)
            }

            MediatorResult.Success(endOfPaginationReached = films.results.isEmpty())

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }

    }
}


