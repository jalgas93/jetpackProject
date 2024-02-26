package com.octobank.jetpack_3_1.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.octobank.jetpack_3_1.data.NewsApi
import com.octobank.jetpack_3_1.data.NewsRepository
import com.octobank.jetpack_3_1.data.remote.dto.NewsPagingSource
import com.octobank.jetpack_3_1.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private  val newsApi: NewsApi
) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}