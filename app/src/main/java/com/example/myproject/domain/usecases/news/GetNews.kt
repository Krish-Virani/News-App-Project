package com.example.myproject.domain.usecases.news

import androidx.paging.PagingData
import com.example.myproject.data.remote.NewsResponce
import com.example.myproject.domain.model.Data
import com.example.myproject.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(): NewsResponce{
        return newsRepository.getNews()
    }
}