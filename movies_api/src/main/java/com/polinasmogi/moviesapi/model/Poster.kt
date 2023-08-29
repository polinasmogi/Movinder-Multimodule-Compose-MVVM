package com.polinasmogi.moviesapi.model

import com.google.gson.annotations.SerializedName

data class Poster(

    @SerializedName("url"        ) var url        : String?,
    @SerializedName("previewUrl" ) var previewUrl : String?

)
