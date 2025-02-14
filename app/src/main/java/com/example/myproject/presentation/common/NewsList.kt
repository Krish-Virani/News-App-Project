package com.example.myproject.presentation.common

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.myproject.data.remote.NewsResponce
import com.example.myproject.domain.model.Data

@Composable
fun NewsList(
    modifier: Modifier = Modifier,
    newsResponce: NewsResponce,
    onClick:(Data)->Unit
){

    LazyColumn {
        Log.d("SIZE", "handleGoogleSignIn: ${newsResponce.articles.size}")
        items(newsResponce.articles) { x ->
            NewsCard(article = x, onClick = { onClick })
        }
    }

}

@Composable
fun HandlePagingResult(
    datas: LazyPagingItems<Data>
): Boolean{
    val loadState = datas.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

        return when{
            loadState.refresh is LoadState.Loading -> {
                Text(text = "Loading")
                false
            }
            error!=null -> {
                Text(text = "Empty Screen")
                Log.e("NewsRepositoryImpl", "Error fetching news: ${"e.message"}")
                false
            }
            else -> true

        }
}





