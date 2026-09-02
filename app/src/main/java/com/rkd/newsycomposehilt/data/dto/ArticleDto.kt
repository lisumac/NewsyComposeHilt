package com.rkd.newsycomposehilt.data.dto

/**
 * ArticleDto
 */
data class ArticleDto(
    val article_id: String?,

    val title: String?,

    val link: String?,

    val description: String?,

    val image_url: String?,

    val pubDate: String?,

    val source_name: String?,

    val source_url: String?,

    val language: String?,

    val country: List<String>?,

    val category: List<String>?
)
