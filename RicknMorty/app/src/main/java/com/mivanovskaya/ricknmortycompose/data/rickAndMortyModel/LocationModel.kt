package com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel

data class LocationModel(
    val info: Info,
    val results: List<Result>
) {
    data class Info(
        val count: Int,
        val next: String,
        val pages: Int,
        val prev: Any
    )

    data class Result(
        val created: String,
        val dimension: String,
        val id: Int,
        val name: String,
        val residents: List<String>,
        val type: String,
        val url: String
    )
}