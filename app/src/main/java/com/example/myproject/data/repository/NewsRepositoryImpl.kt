package com.example.myproject.data.repository

import android.util.Log
import com.example.myproject.data.remote.NewsApi
import com.example.myproject.data.remote.NewsResponce
import com.example.myproject.domain.model.Data
import com.example.myproject.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsApi: NewsApi
): NewsRepository {
    override suspend fun getNews(): NewsResponce {
        return newsApi.getNews()
//        return try {
//            newsApi.getNews() // Directly return list of news data
//        } catch (e: Exception) {
//            Log.e("NewsRepository", "Error fetching news: ${e.message}")
//            // Return an empty list on failure
//        }
    }
}