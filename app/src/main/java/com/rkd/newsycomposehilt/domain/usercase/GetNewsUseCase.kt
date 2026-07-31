package com.rkd.newsycomposehilt.domain.usercase


import com.rkd.newsycomposehilt.domain.model.Article
import com.rkd.newsycomposehilt.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    suspend operator fun invoke(): List<Article> {
        return repository.getNews()
    }
}