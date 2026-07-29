package com.rkd.newsycomposehilt.data.remote

import com.rkd.newsycomposehilt.data.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * NewsApi
 */
interface NewsApi {

    @GET("latest")
    suspend fun getTopHeadlines(

        @Query("apikey")
        apiKey: String,

        @Query("country")
        country: String = "in",

        @Query("language")
        language: String = "en"

    ): NewsResponse
}