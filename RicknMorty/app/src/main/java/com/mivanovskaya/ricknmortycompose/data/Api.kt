package com.mivanovskaya.ricknmortycompose.data

import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.CharactersModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.EpisodeModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RicknMortyService {
    @GET("/api/character")
    suspend fun getCharacter(@Query("page") page: Int): CharactersModel

    @GET("/api/location")
    suspend fun getLocationList(@Query("page") page: Int): LocationModel

    @GET("/api/episode/{id}")
    suspend fun getEpisodeList(@Path("id") id: String): List<EpisodeModel>

}