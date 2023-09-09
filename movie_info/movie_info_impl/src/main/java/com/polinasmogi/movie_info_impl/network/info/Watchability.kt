package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class Watchability (

  @SerializedName("items" ) var items : ArrayList<com.polinasmogi.movie_info_impl.network.info.Items> = arrayListOf()

)