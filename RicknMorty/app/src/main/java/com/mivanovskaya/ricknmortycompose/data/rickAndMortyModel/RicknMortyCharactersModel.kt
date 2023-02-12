package com.mivanovskaya.ricknmortycompose.data.rickAndMortyModel

data class RicknMortyCharactersModel(
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

/*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RicknMortyCharactersModel(
    @Json(name = "info") val info: Info?,
    @Json(name = "results") val results: List<Results>
) {
    @JsonClass(generateAdapter = true)
    data class Info(
        @Json(name="count") val count: Int?,
        @Json(name="pages") val pages: Int?
    )
    @JsonClass(generateAdapter = true)
    data class Results(
        @Json(name="episode") val episode: List<String>?,
        @Json(name="gender") val gender: String?,
        @Json(name="id") val id: Int?,
        @Json(name="image") val image: String?,
        @Json(name="location") val location: Location?,
        @Json(name="name") val name: String?,
        @Json(name="species") val species: String?,
        @Json(name="status") val status: String?,
        @Json(name="type") val type: String?,
        @Json(name="url") val url: String?
    ) {
        @JsonClass(generateAdapter = true)
        data class Location(
            @Json(name="name") val name: String?
        )
    }
}
*/
