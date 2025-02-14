package com.example.myproject.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myproject.presentation.common.NewsList

@Composable
fun HomeScreen(
               navController: NavController,
               viewModel: HomeViewModel = hiltViewModel()
) {
    var searchQuery by remember { mutableStateOf(TextFieldValue("")) }
    val newsResponce by viewModel.news.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .background(Color.Black)
    ){
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Latest hot!",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                letterSpacing = 0.5.sp
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Search Bar
        BasicTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 18.sp
            ),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .background(
                            Brush.linearGradient(
                                colors = listOf(Color.Gray, Color.Transparent, Color.LightGray),
                                start = Offset(0f, -20f), // Starting point of the gradient
                                end = Offset(0f, 280f), // Ending point of the gradient
                                tileMode = TileMode.Mirror
                            ), shape = CircleShape
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                ) {
                    if (searchQuery.text.isEmpty()) {
                        Row(
                            verticalAlignment = Alignment.Top
                        ) {
                            Icon(imageVector = Icons.Default.Search, contentDescription = null, tint = Color.White)
                            Spacer(modifier = Modifier.padding(16.dp))
                            Text(
                                text = "Search news...",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                    innerTextField()
                }
            },
            modifier = Modifier.fillMaxWidth()
            //.border(width = 1.dp, brush = Brush.verticalGradient(colors = listOf(Color.Transparent,Color.DarkGray)), shape = CircleShape)
        )
        Spacer(modifier = Modifier.height(16.dp))
        newsResponce?.let { NewsList(newsResponce = it, onClick = {}) }
    }

}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyProjectTheme {
//        NewsCard(newsItem = News("Breaking: Major Event Shocks the World","https://imgs.search.brave.com/OTuKCAjNcuYQAt_nwfZyOI28TeO9mi2R8f2V5GJNG6Y/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly93d3cu/aXN0b2NrcGhvdG8u/Y29tL3Jlc291cmNl/cy9pbWFnZXMvUGhv/dG9GVExQL05hdHVy/ZUxhbmRzY2FwZXMt/NTE5NzYwOTg0Lmpw/Zw","Stay tuned for the latest updates on this breaking news."))
//    }
//}




