package com.mivanovskaya.ricknmortycompose.data

import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.CharactersModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.EpisodeModel
import com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel.LocationModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://rickandmortyapi.com"

interface Api {
    @GET("/api/character")
    suspend fun getCharacter(@Query("page") page: Int): CharactersModel

    @GET("/api/location")
    suspend fun getLocationList(@Query("page") page: Int): LocationModel

    @GET("/api/episode/{id}")
    suspend fun getEpisodeList(@Path("id") id: String): List<EpisodeModel>

    companion object {
        val retrofit: Api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }
}