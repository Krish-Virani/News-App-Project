package com.example.myproject.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myproject.domain.model.Article
import com.example.myproject.domain.model.Data

@Composable
fun NewsCard(
    article: Article,
    onClick:()->Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        modifier = Modifier.clickable{ onClick() }
    ){
        AsyncImage(
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(4.dp)),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(3.dp)
                .height(96.dp)

        ) {
            article.title?.let {
                Text(
                    text = it,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    maxLines = 3,
                    textAlign = TextAlign.Left,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                article.author?.let {
                    Text(
                        text = it,
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Icon(Icons.Default.DateRange, contentDescription = null, tint = Color.Gray )
                Spacer(modifier = Modifier.padding(6.dp))
                article.publishedAt?.let {
                    Text(
                        text = it,
                        color = Color.Gray,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                    )
                }

            }
        }

    }

}