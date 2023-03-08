package com.mivanovskaya.ricknmortycompose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mivanovskaya.ricknmortycompose.data.paging.CharacterSource
import com.mivanovskaya.ricknmortycompose.data.paging.LocationSource
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.CharactersModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.EpisodeModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel
import com.mivanovskaya.ricknmortycompose.domain.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val characterSource: CharacterSource,
    private val locationSource: LocationSource
) : ViewModel() {

    val characters: Flow<PagingData<CharactersModel.Results>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { characterSource }
    ).flow.cachedIn(viewModelScope)

    val locations: Flow<PagingData<LocationModel.Result>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = { locationSource }
    ).flow.cachedIn(viewModelScope)

    var result: CharactersModel.Results? = null
    var episodes = emptyList<EpisodeModel>().toMutableList()

    fun getEpisodeList(episode: List<String>?) {
        viewModelScope.launch {
            val toNumbers = mutableListOf<String>()
            episode?.forEach {
                toNumbers.add(it.replace(Regex("[^0-9]"), ""))
            }
            episodes =
                mainRepository.getEpisodeList(toNumbers.toString()) as MutableList<EpisodeModel>
        }
    }
}