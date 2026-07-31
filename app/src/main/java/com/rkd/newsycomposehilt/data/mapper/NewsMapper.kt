package com.rkd.newsycomposehilt.data.mapper

import com.rkd.newsycomposehilt.data.dto.ArticleDto
import com.rkd.newsycomposehilt.domain.model.Article

fun ArticleDto.toArticle(): Article {

    return Article(
        id = article_id ?: "",
        title = title ?: "",
        description = description ?: "",
        imageUrl = image_url ?: "",
        articleUrl = link ?: "",
        publishedAt = pubDate ?: "",
        sourceName = source_name ?: ""
    )
}