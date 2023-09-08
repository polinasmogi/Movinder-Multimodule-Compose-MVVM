package com.polinasmogi.moviesapi.model.info

import com.google.gson.annotations.SerializedName


data class Distributors (

  @SerializedName("distributor"        ) var distributor        : String? = null,
  @SerializedName("distributorRelease" ) var distributorRelease : String? = null

)