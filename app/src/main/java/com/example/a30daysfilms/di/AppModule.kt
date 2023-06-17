package com.example.rickandmortygraphqlapi.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.example.a30daysfilms.data.local.FilmDatabase
import com.example.a30daysfilms.data.local.FilmEntity
import com.example.a30daysfilms.data.remote.FilmRemoteMediator
import com.example.a30daysfilms.data.remote.FilmsApi
import com.example.a30daysfilms.data.remote.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFilmsApi(): FilmsApi {

        return Retrofit.Builder().baseUrl(FilmsApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).client(getClient()).build()
            .create(FilmsApi::class.java)
    }

    fun getClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HeaderInterceptor()).build()
    }

    @Provides
    @Singleton
    fun provideFilmDataBase(@ApplicationContext context: Context): FilmDatabase {
        return Room.databaseBuilder(
            context = context,
            FilmDatabase::class.java,
            "films.db"
        ).build()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideFilmPager(
        filmDatabase: FilmDatabase,
        filmsApi: FilmsApi
    ): Pager<Int, FilmEntity> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = FilmRemoteMediator(filmDatabase, filmsApi),
            pagingSourceFactory = {
                filmDatabase.filmDao.pagingSource()
            }
        )
    }


}