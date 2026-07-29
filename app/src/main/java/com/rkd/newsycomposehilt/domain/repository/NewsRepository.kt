package com.rkd.newsycomposehilt.domain.repository

import com.rkd.newsycomposehilt.data.dto.NewsResponse
import com.rkd.newsycomposehilt.domain.model.Article

interface NewsRepository {

    suspend fun getNews(): List<Article>
}