package com.example.a30daysfilms.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface FilmDao {

    @Upsert
    suspend fun upsertAll(films:List<FilmEntity>)

    @Query("SELECT * FROM filmentity")
    fun pagingSource():PagingSource<Int,FilmEntity>

    @Query("SELECT * FROM filmentity WHERE id=:id")
    fun getFilmById(id:Int):FilmEntity

    @Query("SELECT id FROM filmentity ORDER BY id DESC LIMIT 1")
    fun getLastId():Int

    @Query("DELETE FROM filmentity")
    suspend fun clearAll()

}