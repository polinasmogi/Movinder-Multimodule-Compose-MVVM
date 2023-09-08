package com.polinasmogi.moviesapi.network.model.model

import com.google.gson.annotations.SerializedName

data class Poster(

    @SerializedName("url"        ) var url        : String?,
    @SerializedName("previewUrl" ) var previewUrl : String?

)
