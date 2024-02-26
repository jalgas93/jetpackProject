package com.octobank.jetpack_3_1.domain.usecases.news

import androidx.paging.PagingData
import com.octobank.jetpack_3_1.data.NewsRepository
import com.octobank.jetpack_3_1.data.remote.dto.NewsPagingSource
import com.octobank.jetpack_3_1.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository,
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}