package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class Backdrop (

  @SerializedName("url"        ) var url        : String? = null,
  @SerializedName("previewUrl" ) var previewUrl : String? = null

)