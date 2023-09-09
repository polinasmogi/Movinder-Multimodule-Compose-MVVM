package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class Rating (

  @SerializedName("kp"                 ) var kp                 : Double? = null,
  @SerializedName("imdb"               ) var imdb               : Int?    = null,
  @SerializedName("filmCritics"        ) var filmCritics        : Int?    = null,
  @SerializedName("russianFilmCritics" ) var russianFilmCritics : Int?    = null,
  @SerializedName("await"              ) var await              : String? = null

)