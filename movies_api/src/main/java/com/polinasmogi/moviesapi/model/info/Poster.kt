package com.polinasmogi.moviesapi.model.info

import com.google.gson.annotations.SerializedName


data class Poster (

  @SerializedName("url"        ) var url        : String? = null,
  @SerializedName("previewUrl" ) var previewUrl : String? = null

)