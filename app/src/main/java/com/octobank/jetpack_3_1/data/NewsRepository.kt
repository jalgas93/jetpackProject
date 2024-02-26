package com.octobank.jetpack_3_1.data

import kotlinx.coroutines.flow.Flow
import androidx.paging.PagingData
import com.octobank.jetpack_3_1.domain.model.Article


interface NewsRepository {
    fun getNews(sources:List<String>):Flow<PagingData<Article>>
}