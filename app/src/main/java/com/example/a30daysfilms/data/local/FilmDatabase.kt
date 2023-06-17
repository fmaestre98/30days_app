package com.example.a30daysfilms.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FilmEntity::class],
    version = 1
)
abstract class FilmDatabase : RoomDatabase() {

    abstract val filmDao: FilmDao
}