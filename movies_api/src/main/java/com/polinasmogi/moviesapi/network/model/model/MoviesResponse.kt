package com.polinasmogi.moviesapi.network.model.model

import com.google.gson.annotations.SerializedName

data class MoviesResponse(

    @SerializedName("docs"  ) var docs  : List<Doc>,
    @SerializedName("total" ) var total : Int?,
    @SerializedName("limit" ) var limit : Int?,
    @SerializedName("page"  ) var page  : Int?,
    @SerializedName("pages" ) var pages : Int?

)
