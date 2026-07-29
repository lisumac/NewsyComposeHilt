package com.rkd.newsycomposehilt.data.dto

/**
 * News Response
 */
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val results: List<ArticleDto>,
    val nextPage: String?
)
