package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class Technology (

  @SerializedName("hasImax" ) var hasImax : Boolean? = null,
  @SerializedName("has3D"   ) var has3D   : Boolean? = null

)