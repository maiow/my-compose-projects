package com.mivanovskaya.ricknmortycompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mivanovskaya.ricknmortycompose.data.MainRepository
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel.Result

class LocationSource : PagingSource<Int, Result>() {
    private val repository = MainRepository()

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