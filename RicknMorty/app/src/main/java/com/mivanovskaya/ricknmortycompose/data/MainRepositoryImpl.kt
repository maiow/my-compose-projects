package com.mivanovskaya.ricknmortycompose.data

import com.mivanovskaya.ricknmortycompose.domain.MainRepository
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.CharactersModel.Results
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.EpisodeModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val retrofit: RicknMortyService
) : MainRepository {
    override suspend fun getCharacter(page: Int): List<Results> {
        return retrofit.getCharacter(page).results
    }

    override suspend fun getLocation(page: Int): List<LocationModel.Result> {
        return retrofit.getLocationList(page).results
    }

    override suspend fun getEpisodeList(id: String): List<EpisodeModel> {
        return retrofit.getEpisodeList(id)
    }
}