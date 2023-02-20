package com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel

class LocationModel(
    val results: List<Result>
) {
    class Result(
        val created: String,
        val dimension: String,
        val name: String,
        val type: String
    )
}