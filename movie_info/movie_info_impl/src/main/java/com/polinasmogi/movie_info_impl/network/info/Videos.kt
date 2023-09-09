package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class Videos (

    @SerializedName("trailers" ) var trailers : ArrayList<com.polinasmogi.movie_info_impl.network.info.Trailers> = arrayListOf(),
    @SerializedName("teasers"  ) var teasers  : ArrayList<String>   = arrayListOf()

)