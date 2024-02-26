package com.octobank.jetpack_3_1.data

import com.octobank.jetpack_3_1.data.remote.NewsResponse
import com.octobank.jetpack_3_1.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApi {
    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY,
    ): NewsResponse
}