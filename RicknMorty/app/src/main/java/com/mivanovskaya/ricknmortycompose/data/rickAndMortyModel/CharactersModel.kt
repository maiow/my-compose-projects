package com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel

data class CharactersModel(
    val info: Info?,
    val results: List<Results>
) {
    data class Info(
        val count: Int?,
        val pages: Int?
    )

    data class Results(
        val episode: List<String>,
        val gender: String?,
        val id: Int?,
        val image: String?,
        val location: Location,
        val name: String,
        val species: String?,
        val status: String?,
        val type: String?,
        val url: String?
    ) {
        data class Location(
            val name: String
        )
    }
}
