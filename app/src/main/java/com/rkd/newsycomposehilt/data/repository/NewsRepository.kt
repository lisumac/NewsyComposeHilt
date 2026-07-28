package com.rkd.newsycomposehilt.data.repository

import com.rkd.newsycomposehilt.data.dto.NewsResponse

interface NewsRepository {

    suspend fun getNews(): NewsResponse
}