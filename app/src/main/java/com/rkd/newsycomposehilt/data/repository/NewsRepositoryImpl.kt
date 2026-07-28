package com.rkd.newsycomposehilt.data.repository

import com.rkd.newsycomposehilt.data.NewsApi
import com.rkd.newsycomposehilt.data.dto.NewsResponse
import com.rkd.newsycomposehilt.utill.Constants
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi) : NewsRepository {
    override suspend fun getNews(): NewsResponse {
        return api.getTopHeadlines(
            apiKey = Constants.API_KEY
        )
    }
}