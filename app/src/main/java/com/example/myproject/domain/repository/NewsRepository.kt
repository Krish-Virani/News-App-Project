package com.example.myproject.domain.repository

import androidx.paging.PagingData
import com.example.myproject.data.remote.NewsResponce
import com.example.myproject.domain.model.Data
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNews(): NewsResponce
}