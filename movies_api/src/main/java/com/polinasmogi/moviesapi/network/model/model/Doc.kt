package com.polinasmogi.moviesapi.network.model.model

import com.google.gson.annotations.SerializedName

data class Doc(

    @SerializedName("id"               ) var id               : Int,
    @SerializedName("name"             ) var name             : String,
    @SerializedName("poster"           ) var poster           : Poster?,
    @SerializedName("shortDescription" ) var shortDescription : String?,
    @SerializedName("genres"           ) var genres           : List<Genres>,
    @SerializedName("countries"        ) var countries        : List<Countries>

)
