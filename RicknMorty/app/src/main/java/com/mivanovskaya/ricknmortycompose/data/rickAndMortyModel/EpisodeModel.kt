package com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel

data class EpisodeModel(
    val air_date: String,
    val characters: List<String>?,
    val created: String?,
    val episode: String,
    val id: Int?,
    val name: String,
    val url: String?
)