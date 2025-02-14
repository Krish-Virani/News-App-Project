package com.example.myproject.di

import android.util.Log
import com.example.myproject.data.remote.NewsApi
import com.example.myproject.data.repository.NewsRepositoryImpl
import com.example.myproject.domain.repository.NewsRepository
import com.example.myproject.domain.usecases.news.GetNews
import com.example.myproject.domain.usecases.news.NewsUseCases
import com.example.myproject.util.Constants.API_KEY
import com.example.myproject.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }


    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            GetNews(newsRepository)
        )
    }
}