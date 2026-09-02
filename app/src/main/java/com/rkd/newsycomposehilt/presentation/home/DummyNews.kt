package com.rkd.newsycomposehilt.presentation.home


import com.rkd.newsycomposehilt.domain.model.Article

val dummyArticles = listOf(

    Article(
        id = "1",
        title = "Android 17 Officially Released",
        description = "Google announced Android 17 with exciting AI-powered features for developers.",
        imageUrl = "https://picsum.photos/600/400",
        articleUrl = "",
        publishedAt = "2 hours ago",
        sourceName = "Google"
    ),

    Article(
        id = "2",
        title = "Tesla Launches New EV",
        description = "Tesla unveiled its latest electric vehicle with improved battery life.",
        imageUrl = "https://picsum.photos/600/401",
        articleUrl = "",
        publishedAt = "4 hours ago",
        sourceName = "Reuters"
    ),

    Article(
        id = "3",
        title = "OpenAI Releases New GPT Model",
        description = "OpenAI introduced new improvements for developers and enterprises.",
        imageUrl = "https://picsum.photos/600/402",
        articleUrl = "",
        publishedAt = "5 hours ago",
        sourceName = "OpenAI"
    )
)