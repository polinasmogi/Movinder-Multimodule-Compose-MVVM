package com.polinasmogi.moviesapi.model.info

import com.google.gson.annotations.SerializedName


data class Videos (

  @SerializedName("trailers" ) var trailers : ArrayList<Trailers> = arrayListOf(),
  @SerializedName("teasers"  ) var teasers  : ArrayList<String>   = arrayListOf()

)