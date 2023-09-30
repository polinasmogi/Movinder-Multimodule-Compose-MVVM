package com.polinasmogi.movie_info_impl.network.info

import com.google.gson.annotations.SerializedName


data class MovieInfoResponse (

    @SerializedName("id"                  ) var id                  : Int?                           = null,
    @SerializedName("name"                ) var name                : String?                        = null,
    @SerializedName("description"         ) var description         : String?                        = null,
    @SerializedName("year"                ) var year                : Int?                           = null,
    @SerializedName("poster"              ) var poster              : Poster?                        = null,
    @SerializedName("logo"                ) var logo                : Logo?                          = null,
    @SerializedName("genres"              ) var genres              : ArrayList<Genres>              = arrayListOf(),
    @SerializedName("persons"             ) var persons             : ArrayList<Person>              = arrayListOf(),

    // uncomment that fields when ui will be ready
//    @SerializedName("videos"              ) var videos              : Videos?                        = Videos(),
//    @SerializedName("type"                ) var type                : String?                        = null,
//    @SerializedName("externalId"          ) var externalId          : ExternalId?                    = ExternalId(),
//    @SerializedName("rating"              ) var rating              : Rating?                        = Rating(),
//    @SerializedName("votes"               ) var votes               : Votes?                         = Votes(),
//    @SerializedName("distributors"        ) var distributors        : Distributors?                  = Distributors(),
//    @SerializedName("premiere"            ) var premiere            : Premiere?                      = Premiere(),
//    @SerializedName("slogan"              ) var slogan              : String?                        = null,
//    @SerializedName("facts"               ) var facts               : ArrayList<String>              = arrayListOf(),
//    @SerializedName("countries"           ) var countries           : ArrayList<Countries>           = arrayListOf(),
//    @SerializedName("seasonsInfo"         ) var seasonsInfo         : ArrayList<SeasonsInfo>         = arrayListOf(),
//    @SerializedName("images"              ) var images              : Images?                        = Images(),
//    @SerializedName("lists"               ) var lists               : ArrayList<String>              = arrayListOf(),
//    @SerializedName("spokenLanguages"     ) var spokenLanguages     : ArrayList<SpokenLanguages>     = arrayListOf(),
//    @SerializedName("productionCompanies" ) var productionCompanies : ArrayList<ProductionCompanies> = arrayListOf(),
//    @SerializedName("typeNumber"          ) var typeNumber          : Int?                           = null,
//    @SerializedName("alternativeName"     ) var alternativeName     : String?                        = null,
//    @SerializedName("backdrop"            ) var backdrop            : Backdrop?                      = Backdrop(),
//    @SerializedName("budget"              ) var budget              : Budget?                        = Budget(),
//    @SerializedName("enName"              ) var enName              : String?                        = null,
//    @SerializedName("movieLength"         ) var movieLength         : String?                        = null,
//    @SerializedName("names"               ) var names               : ArrayList<Names>               = arrayListOf(),
//    @SerializedName("networks"            ) var networks            : ArrayList<Networks>            = arrayListOf(),
//    @SerializedName("status"              ) var status              : String?                        = null,
//    @SerializedName("subType"             ) var subType             : String?                        = null,
//    @SerializedName("updateDates"         ) var updateDates         : ArrayList<String>              = arrayListOf(),
//    @SerializedName("updatedAt"           ) var updatedAt           : String?                        = null,
//    @SerializedName("fees"                ) var fees                : Fees?                          = Fees(),
//    @SerializedName("similarMovies"       ) var similarMovies       : ArrayList<String>              = arrayListOf(),
//    @SerializedName("sequelsAndPrequels"  ) var sequelsAndPrequels  : ArrayList<String>              = arrayListOf(),
//    @SerializedName("ratingMpaa"          ) var ratingMpaa          : String?                        = null,
//    @SerializedName("shortDescription"    ) var shortDescription    : String?                        = null,
//    @SerializedName("technology"          ) var technology          : Technology?                    = Technology(),
//    @SerializedName("ticketsOnSale"       ) var ticketsOnSale       : Boolean?                       = null,
//    @SerializedName("ageRating"           ) var ageRating           : Int?                           = null,
//    @SerializedName("watchability"        ) var watchability        : Watchability?                  = Watchability(),
//    @SerializedName("releaseYears"        ) var releaseYears        : ArrayList<ReleaseYears>        = arrayListOf(),
//    @SerializedName("top10"               ) var top10               : String?                        = null,
//    @SerializedName("top250"              ) var top250              : String?                        = null,
//    @SerializedName("deletedAt"           ) var deletedAt           : String?                        = null,
//    @SerializedName("isSeries"            ) var isSeries            : Boolean?                       = null,
//    @SerializedName("seriesLength"        ) var seriesLength        : Int?                           = null,
//    @SerializedName("totalSeriesLength"   ) var totalSeriesLength   : String?                        = null

)