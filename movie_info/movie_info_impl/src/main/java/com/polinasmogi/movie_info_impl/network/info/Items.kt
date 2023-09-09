package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class Items (

    @SerializedName("name" ) var name : String? = null,
    @SerializedName("logo" ) var logo : com.polinasmogi.movie_info_impl.network.info.Logo?   = com.polinasmogi.movie_info_impl.network.info.Logo(),
    @SerializedName("url"  ) var url  : String? = null

)