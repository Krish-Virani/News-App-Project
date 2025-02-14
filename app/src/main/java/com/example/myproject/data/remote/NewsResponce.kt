package com.example.myproject.data.remote

import com.example.myproject.domain.model.Article
import com.google.gson.annotations.SerializedName

data class NewsResponce(
    @SerializedName("articles") val articles: List<Article>,
    @SerializedName("status") val status: String?,
    @SerializedName("totalResults") val totalResults: Int
)