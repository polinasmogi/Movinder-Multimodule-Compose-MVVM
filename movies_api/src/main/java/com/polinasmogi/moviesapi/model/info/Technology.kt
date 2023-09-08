package com.polinasmogi.moviesapi.model.info

import com.google.gson.annotations.SerializedName


data class Technology (

  @SerializedName("hasImax" ) var hasImax : Boolean? = null,
  @SerializedName("has3D"   ) var has3D   : Boolean? = null

)