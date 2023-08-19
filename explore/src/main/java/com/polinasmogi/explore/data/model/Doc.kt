package com.polinasmogi.explore.data.model

import com.google.gson.annotations.SerializedName

data class Doc(

    @SerializedName("id"               ) var id               : Int?,
    @SerializedName("name"             ) var name             : String?,
    @SerializedName("description"      ) var description      : String?,
    @SerializedName("year"             ) var year             : Int?,
    @SerializedName("poster"           ) var poster           : Poster?,
    @SerializedName("genres"           ) var genres           : List<Genres>,
    @SerializedName("countries"        ) var countries        : List<Countries>,
    @SerializedName("shortDescription" ) var shortDescription : String?,
    @SerializedName("logo"             ) var logo             : Logo?

)
