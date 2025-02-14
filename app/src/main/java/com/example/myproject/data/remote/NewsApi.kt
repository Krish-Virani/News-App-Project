package com.example.myproject.data.remote

import com.example.myproject.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("q") q: String = "india",
//        @Query("from") from: String = "2025-01-26",
//        @Query("to") to: String = "2025-01-26",
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponce

}
