package com.mivanovskaya.ricknmortycompose.domain

import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.CharactersModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.EpisodeModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel

interface MainRepository  {

    suspend fun getCharacter(page: Int): List<CharactersModel.Results>

    suspend fun getLocation(page: Int): List<LocationModel.Result>

    suspend fun getEpisodeList(id: String): List<EpisodeModel>
}