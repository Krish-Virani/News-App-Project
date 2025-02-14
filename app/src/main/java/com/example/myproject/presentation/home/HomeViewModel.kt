package com.example.myproject.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.myproject.data.remote.NewsResponce
import com.example.myproject.domain.model.Data
import com.example.myproject.domain.repository.NewsRepository
import com.example.myproject.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository
): ViewModel() {
    private val _news = MutableLiveData<NewsResponce>()
    val news: LiveData<NewsResponce> = _news

    init {
        fetchNews()
    }

    private fun fetchNews() {
        viewModelScope.launch {
            _news.value = newsRepository.getNews()
        }
    }
}