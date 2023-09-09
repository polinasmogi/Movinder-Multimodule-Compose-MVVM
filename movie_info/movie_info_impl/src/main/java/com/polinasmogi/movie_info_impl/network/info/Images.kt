package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class Images (

  @SerializedName("postersCount"   ) var postersCount   : Int? = null,
  @SerializedName("backdropsCount" ) var backdropsCount : Int? = null,
  @SerializedName("framesCount"    ) var framesCount    : Int? = null

)