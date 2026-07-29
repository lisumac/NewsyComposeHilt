package com.rkd.newsycomposehilt.data.repository

import com.rkd.newsycomposehilt.data.mapper.toArticle
import com.rkd.newsycomposehilt.data.remote.NewsApi
import com.rkd.newsycomposehilt.domain.model.Article
import com.rkd.newsycomposehilt.domain.repository.NewsRepository
import com.rkd.newsycomposehilt.util.Constants
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository {

    override suspend fun getNews(): List<Article> {

        val response = api.getTopHeadlines(
            apiKey = Constants.API_KEY
        )

        return response.results.map {
            it.toArticle()
        }?:emptyList()
    }
}