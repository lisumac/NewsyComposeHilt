package com.rkd.newsycomposehilt.presentation.home


import com.rkd.newsycomposehilt.domain.model.Article

data class HomeState(

    val isLoading: Boolean = false,

    val articles: List<Article> = emptyList(),

    val error: String = ""
)