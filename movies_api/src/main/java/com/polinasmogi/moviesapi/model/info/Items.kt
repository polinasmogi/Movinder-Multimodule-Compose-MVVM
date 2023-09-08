package com.polinasmogi.moviesapi.model.info

import com.google.gson.annotations.SerializedName


data class Items (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("logo" ) var logo : Logo?   = Logo(),
  @SerializedName("url"  ) var url  : String? = null

)