package com.github.goutarouh.notioncalendar.di

import com.github.goutarouh.notioncalendar.repository.NotionRepository
import com.github.goutarouh.notioncalendar.repository.data.NotionApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.notion.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }


    @Provides
    fun provideRetrofitService(
        retrofit: Retrofit
    ): NotionApiService {
        return retrofit.create(NotionApiService::class.java)
    }


    @Provides
    fun provideNotionRepository(
        notionApiService: NotionApiService
    ): NotionRepository {
        return NotionRepository(
            notionApiService = notionApiService
        )
    }

}