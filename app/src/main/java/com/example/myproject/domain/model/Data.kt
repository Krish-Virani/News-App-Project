package com.example.myproject.domain.model

data class Data(
    val article_link: String,
    val content: String,
    val creator: String,
    val description: String,
    val id: String,
    val keywords: List<String>,
    val language: String,
    val media_credit: Any,
    val media_description: Any,
    val media_thumbnail: Any,
    val media_type: String,
    val media_url: String,
    val pub_date: String,
    val sentiment: Sentiment,
    val source_link: String,
    val source_title: String,
    val title: String,
    val topics: List<String>
)