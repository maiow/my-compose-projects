package com.mivanovskaya.ricknmortycompose.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mivanovskaya.ricknmortycompose.data.MainRepository
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.CharactersModel

class CharacterSource : PagingSource<Int, CharactersModel.Results>() {
    private val repository = MainRepository()

    override fun getRefreshKey(state: PagingState<Int, CharactersModel.Results>): Int = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharactersModel.Results> {
        val page = params.key ?: 1
        return kotlin.runCatching {
            repository.getCharacter(page)
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