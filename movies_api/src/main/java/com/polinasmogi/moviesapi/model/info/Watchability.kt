package com.polinasmogi.moviesapi.model.info

import com.google.gson.annotations.SerializedName


data class Watchability (

  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf()

)