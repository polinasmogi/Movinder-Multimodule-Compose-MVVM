package com.polinasmogi.moviesapi.model.info

import com.google.gson.annotations.SerializedName


data class Trailers (

  @SerializedName("url"  ) var url  : String? = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("site" ) var site : String? = null

)