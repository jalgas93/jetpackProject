package com.octobank.jetpack_3_1.data.remote

import com.octobank.jetpack_3_1.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)