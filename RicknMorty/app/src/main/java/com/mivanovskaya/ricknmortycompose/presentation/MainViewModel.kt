package com.mivanovskaya.ricknmortycompose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mivanovskaya.ricknmortycompose.data.paging.CharacterSource
import com.mivanovskaya.ricknmortycompose.data.paging.LocationSource
import com.mivanovskaya.ricknmortycompose.data.MainRepository
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.EpisodeModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.RicknMortyCharactersModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val characters: Flow<PagingData<RicknMortyCharactersModel.Results>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { CharacterSource() }
    ).flow.cachedIn(viewModelScope)

    val locations: Flow<PagingData<LocationModel.Result>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { LocationSource() }
    ).flow.cachedIn(viewModelScope)

    var result: RicknMortyCharactersModel.Results? = null
    var episodes = emptyList<EpisodeModel>().toMutableList()

    fun getEpisodeList(episode: List<String>?) {
        viewModelScope.launch {
            val toNumbers = mutableListOf<String>()
            episode?.forEach {
                toNumbers.add(it.replace(Regex("[^0-9]"), ""))
            }
            episodes =
                MainRepository().getEpisodeList(toNumbers.toString()) as MutableList<EpisodeModel>
        }
    }
}
