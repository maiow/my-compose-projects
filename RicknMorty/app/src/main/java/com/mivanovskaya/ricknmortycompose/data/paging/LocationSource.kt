package com.mivanovskaya.ricknmortycompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel.Result
import com.mivanovskaya.ricknmortycompose.domain.MainRepository
import javax.inject.Inject

class LocationSource @Inject constructor(private val repository: MainRepository) :
    PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        val page = params.key ?: 1
        return kotlin.runCatching {
            repository.getLocation(page)
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }
}