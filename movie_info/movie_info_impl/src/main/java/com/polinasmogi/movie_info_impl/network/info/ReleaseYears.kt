package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class ReleaseYears (

  @SerializedName("start" ) var start : Int? = null,
  @SerializedName("end"   ) var end   : Int? = null

)