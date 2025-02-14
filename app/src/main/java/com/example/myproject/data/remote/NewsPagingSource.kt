package com.example.myproject.data.remote

import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.myproject.domain.model.Data

//class NewsPagingSource(
//    private val newsApi: NewsApi
//): PagingSource<String, Data>() {
//    override fun getRefreshKey(state: PagingState<String, Data>): String? {
//        return null
//    }
//
//    @OptIn(UnstableApi::class)
//    override suspend fun load(params: LoadParams<String>): LoadResult<String, Data> {
//        val cursor = null
//        return try {
//            val newsResponce= newsApi.getNews(cursor)
//            if (newsResponce.data.isEmpty()) {
//                Log.e("NewsPagingSource", "No data returned from API")
//            }
//
//            LoadResult.Page(
//                data = newsResponce.data,
//                prevKey = null,
//                nextKey = null
//            )
//
//        }catch (e:Exception){
//            e.printStackTrace()
//            Log.d("Issue", "handleGoogleSignIn: ${e.message}")
//            LoadResult.Error(
//                throwable = e
//            )
//        }
//
//    }
//}