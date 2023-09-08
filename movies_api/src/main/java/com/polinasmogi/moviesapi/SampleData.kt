package com.polinasmogi.moviesapi

import com.google.gson.Gson
import com.polinasmogi.moviesapi.model.MovieModel
import com.polinasmogi.moviesapi.model.info.MovieInfoResponse
import com.polinasmogi.moviesapi.network.model.model.Countries
import com.polinasmogi.moviesapi.network.model.model.Doc
import com.polinasmogi.moviesapi.network.model.model.Genres
import com.polinasmogi.moviesapi.network.model.model.Poster

object SampleData {

    val movieA = Doc(
        id = 1,
        name = "1+1",
        poster = Poster(
            url = "https://st.kp.yandex.net/images/film_big/535341.jpg",
            previewUrl = "https://st.kp.yandex.net/images/film_iphone/iphone360_535341.jpg"
        ),
        genres = listOf(
            Genres(name = "драма"),
            Genres(name = "комедия"),
            Genres(name = "биография")
        ),
        countries = listOf(
            Countries(name = "Франция")
        ),
        shortDescription = "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си"
    )

    val movieAModel = MovieModel (
        id = 1,
        name = "1+1",
        posterUrl = "https://st.kp.yandex.net/images/film_big/535341.jpg",
        genresString = "драма, комедия",
        shortDescription = "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си"
    )

    val movieResponse = "{\n" +
            "  \"videos\": {\n" +
            "    \"trailers\": [\n" +
            "      {\n" +
            "        \"url\": \"https://www.youtube.com/watch?v=bmNRtmK1vYE\",\n" +
            "        \"name\": \"Тизер (сезон 1)\",\n" +
            "        \"site\": \"youtube\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"url\": \"https://www.youtube.com/embed/m0oe3YcTPoA\",\n" +
            "        \"name\": \"W -Official Trailer | Lee jong suk and Han hyo joo 2016 Kdrama\",\n" +
            "        \"site\": \"youtube\",\n" +
            "        \"type\": \"TRAILER\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"teasers\": []\n" +
            "  },\n" +
            "  \"id\": 986594,\n" +
            "  \"type\": \"tv-series\",\n" +
            "  \"externalId\": {\n" +
            "    \"kpHD\": \"442aa94882762a9cb68d228db4d5345a\",\n" +
            "    \"imdb\": \"tt5797194\",\n" +
            "    \"tmdb\": 66330\n" +
            "  },\n" +
            "  \"name\": \"Параллельные миры\",\n" +
            "  \"rating\": {\n" +
            "    \"kp\": 8.135,\n" +
            "    \"imdb\": 8,\n" +
            "    \"filmCritics\": 0,\n" +
            "    \"russianFilmCritics\": 0,\n" +
            "    \"await\": null\n" +
            "  },\n" +
            "  \"description\": \"История о странном и загадочном романе между парнем Кан-чхолем, который очень богат, но существует только в вэб-комиксе «W», и девушкой О Ён-джу, которая является хирургом в реальном мире.\",\n" +
            "  \"votes\": {\n" +
            "    \"kp\": 46470,\n" +
            "    \"imdb\": 12136,\n" +
            "    \"filmCritics\": 0,\n" +
            "    \"russianFilmCritics\": 0,\n" +
            "    \"await\": 17\n" +
            "  },\n" +
            "  \"distributors\": {\n" +
            "    \"distributor\": null,\n" +
            "    \"distributorRelease\": null\n" +
            "  },\n" +
            "  \"premiere\": {\n" +
            "    \"world\": \"2016-07-20T00:00:00.000Z\"\n" +
            "  },\n" +
            "  \"slogan\": null,\n" +
            "  \"year\": 2016,\n" +
            "  \"poster\": {\n" +
            "    \"url\": \"https://st.kp.yandex.net/images/film_big/986594.jpg\",\n" +
            "    \"previewUrl\": \"https://st.kp.yandex.net/images/film_iphone/iphone360_986594.jpg\"\n" +
            "  },\n" +
            "  \"facts\": [],\n" +
            "  \"genres\": [\n" +
            "    {\n" +
            "      \"name\": \"мелодрама\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"фэнтези\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"триллер\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"countries\": [\n" +
            "    {\n" +
            "      \"name\": \"Корея Южная\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"seasonsInfo\": [\n" +
            "    {\n" +
            "      \"number\": 0,\n" +
            "      \"episodesCount\": 2\n" +
            "    },\n" +
            "    {\n" +
            "      \"number\": 1,\n" +
            "      \"episodesCount\": 16\n" +
            "    }\n" +
            "  ],\n" +
            "  \"persons\": [\n" +
            "    {\n" +
            "      \"id\": 2797801,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_2797801.jpg\",\n" +
            "      \"name\": \"Ли Джон-сок\",\n" +
            "      \"enName\": \"Lee Jong-seok\",\n" +
            "      \"description\": \"Kang Cheol\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 1191715,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_1191715.jpg\",\n" +
            "      \"name\": \"Хан Хё-джу\",\n" +
            "      \"enName\": \"Han Hyo-joo\",\n" +
            "      \"description\": \"Oh Yeon-joo\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4240641,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_4240641.jpg\",\n" +
            "      \"name\": \"Чон Ю-джин\",\n" +
            "      \"enName\": \"Jeong Yoo-jin\",\n" +
            "      \"description\": \"Yoon So-hee\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4151324,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_4151324.jpg\",\n" +
            "      \"name\": \"Кан Ги-ён\",\n" +
            "      \"enName\": \"Kang Gi-yeong\",\n" +
            "      \"description\": \"Kang Seok-beom\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 493601,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_493601.jpg\",\n" +
            "      \"name\": \"Ким И-сон\",\n" +
            "      \"enName\": \"Kim Ee-seong\",\n" +
            "      \"description\": \"Oh Seong-moo / Han Sang-hoon\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3447014,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_3447014.jpg\",\n" +
            "      \"name\": \"Ли Щи-он\",\n" +
            "      \"enName\": \"Lee Shi-eon\",\n" +
            "      \"description\": \"Park Soo-bong\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3933237,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_3933237.jpg\",\n" +
            "      \"name\": \"Ли Тхэ-хван\",\n" +
            "      \"enName\": \"Lee Tae-hwan\",\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 238360,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_238360.jpg\",\n" +
            "      \"name\": \"Пак Вон-сан\",\n" +
            "      \"enName\": \"Park Won-sang\",\n" +
            "      \"description\": \"Han Cheol-ho\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3778547,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_3778547.jpg\",\n" +
            "      \"name\": \"Хо Джон-до\",\n" +
            "      \"enName\": \"Heo Jeong-do\",\n" +
            "      \"description\": \"Park Min-soo\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2088891,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_2088891.jpg\",\n" +
            "      \"name\": \"Хван Сок-чон\",\n" +
            "      \"enName\": \"Hwang Seok-jeong\",\n" +
            "      \"description\": \"Webtoon writer\",\n" +
            "      \"profession\": \"актеры\",\n" +
            "      \"enProfession\": \"actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3534277,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_3534277.jpg\",\n" +
            "      \"name\": \"Чон Дэ-юн\",\n" +
            "      \"enName\": \"Jeong Dae-yoon\",\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"режиссеры\",\n" +
            "      \"enProfession\": \"director\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4498160,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_4498160.jpg\",\n" +
            "      \"name\": \"Глеб Петров\",\n" +
            "      \"enName\": null,\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"актеры дубляжа\",\n" +
            "      \"enProfession\": \"voice_actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4165159,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_4165159.jpg\",\n" +
            "      \"name\": \"Татьяна Манетина\",\n" +
            "      \"enName\": null,\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"актеры дубляжа\",\n" +
            "      \"enProfession\": \"voice_actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 1634448,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_1634448.jpg\",\n" +
            "      \"name\": \"Василиса Воронина\",\n" +
            "      \"enName\": null,\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"актеры дубляжа\",\n" +
            "      \"enProfession\": \"voice_actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 5581849,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_5581849.jpg\",\n" +
            "      \"name\": \"Дмитрий Лунёв\",\n" +
            "      \"enName\": null,\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"актеры дубляжа\",\n" +
            "      \"enProfession\": \"voice_actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2741276,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_2741276.jpg\",\n" +
            "      \"name\": \"Антон Савенков\",\n" +
            "      \"enName\": null,\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"актеры дубляжа\",\n" +
            "      \"enProfession\": \"voice_actor\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2890066,\n" +
            "      \"photo\": \"https://st.kp.yandex.net/images/actor_iphone/iphone360_2890066.jpg\",\n" +
            "      \"name\": \"Сон Джэ-джон\",\n" +
            "      \"enName\": \"Song Jae-jeong\",\n" +
            "      \"description\": null,\n" +
            "      \"profession\": \"редакторы\",\n" +
            "      \"enProfession\": \"writer\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"images\": {\n" +
            "    \"postersCount\": 8,\n" +
            "    \"backdropsCount\": 4,\n" +
            "    \"framesCount\": 0\n" +
            "  },\n" +
            "  \"lists\": [],\n" +
            "  \"spokenLanguages\": [\n" +
            "    {\n" +
            "      \"name\": \"한국어/조선말\",\n" +
            "      \"nameEn\": \"Korean\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"productionCompanies\": [\n" +
            "    {\n" +
            "      \"name\": \"Chorokbaem Media\",\n" +
            "      \"url\": null,\n" +
            "      \"previewUrl\": null\n" +
            "    }\n" +
            "  ],\n" +
            "  \"typeNumber\": 2,\n" +
            "  \"alternativeName\": \"W\",\n" +
            "  \"backdrop\": {\n" +
            "    \"url\": \"https://imagetmdb.com/t/p/original/iOyiuJhKlKY4tVT8EfJ1GwnM2By.jpg\",\n" +
            "    \"previewUrl\": \"https://imagetmdb.com/t/p/w500/iOyiuJhKlKY4tVT8EfJ1GwnM2By.jpg\"\n" +
            "  },\n" +
            "  \"budget\": {},\n" +
            "  \"enName\": \"W: Two Worlds\",\n" +
            "  \"movieLength\": null,\n" +
            "  \"names\": [\n" +
            "    {\n" +
            "      \"name\": \"Параллельные миры\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W-两个世界\",\n" +
            "      \"language\": \"CN\",\n" +
            "      \"type\": \"剧情\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W - Dos Mundos\",\n" +
            "      \"language\": \"ES\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W - Two Worlds\",\n" +
            "      \"language\": \"GB\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W Two Worlds\",\n" +
            "      \"language\": \"GB\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W－兩個世界\",\n" +
            "      \"language\": \"HK\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W-君と僕の世界-\",\n" +
            "      \"language\": \"JP\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W 君と僕の世界\",\n" +
            "      \"language\": \"JP\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W: Два мира\",\n" +
            "      \"language\": \"RU\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"حبّ عابر للعوالم\",\n" +
            "      \"language\": \"SA\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W.Two.Worlds\",\n" +
            "      \"language\": \"TW\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W-兩個世界\",\n" +
            "      \"language\": \"TW\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W 兩個世界\",\n" +
            "      \"language\": \"TW\",\n" +
            "      \"type\": \"Netflix\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W: Два виміри\",\n" +
            "      \"language\": \"UA\",\n" +
            "      \"type\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"W: Two Worlds\",\n" +
            "      \"language\": \"US\",\n" +
            "      \"type\": null\n" +
            "    }\n" +
            "  ],\n" +
            "  \"networks\": [\n" +
            "    {\n" +
            "      \"name\": \"MBC\",\n" +
            "      \"url\": \"https://www.themoviedb.org/t/p/original/pOSCKaZhndUFYtxHXjQOV6xJi1s.png\",\n" +
            "      \"previewUrl\": \"https://www.themoviedb.org/t/p/w500/pOSCKaZhndUFYtxHXjQOV6xJi1s.png\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"completed\",\n" +
            "  \"subType\": \"Сценарированный\",\n" +
            "  \"updateDates\": [],\n" +
            "  \"updatedAt\": \"2023-08-16T15:42:37.301Z\",\n" +
            "  \"fees\": {\n" +
            "    \"world\": {},\n" +
            "    \"russia\": {},\n" +
            "    \"usa\": {}\n" +
            "  },\n" +
            "  \"similarMovies\": [],\n" +
            "  \"sequelsAndPrequels\": [],\n" +
            "  \"ratingMpaa\": null,\n" +
            "  \"shortDescription\": \"Девушка попадает во вселенную вэб-комикса, чтобы спасти его героя. Дорама о любви, не знающей препятствий\",\n" +
            "  \"technology\": {\n" +
            "    \"hasImax\": false,\n" +
            "    \"has3D\": false\n" +
            "  },\n" +
            "  \"ticketsOnSale\": false,\n" +
            "  \"ageRating\": 16,\n" +
            "  \"logo\": {\n" +
            "    \"url\": \"https://imagetmdb.com/t/p/original/cSRihADJdS5PfsL6ImzvAZdNIVI.png\"\n" +
            "  },\n" +
            "  \"watchability\": {\n" +
            "    \"items\": [\n" +
            "      {\n" +
            "        \"name\": \"Okko\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://avatars.mds.yandex.net/get-ott/239697/7713e586-17d1-42d1-ac62-53e9ef1e70c3/orig\"\n" +
            "        },\n" +
            "        \"url\": \"https://okko.tv/serial/w-522598?utm_medium=referral&utm_source=yandex_search&utm_campaign=new_search_feed\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Иви\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://avatars.mds.yandex.net/get-ott/2419418/0dfd1724-848f-4725-9160-abc571f41c11/orig\"\n" +
            "        },\n" +
            "        \"url\": \"https://www.ivi.ru/watch/parallelnyie-miryi?utm_source=yandex&utm_medium=wizard\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"KION\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://avatars.mds.yandex.net/get-ott/239697/daeb142e-3ecc-4bb2-9bff-4827996643ab/orig\"\n" +
            "        },\n" +
            "        \"url\": \"https://kion.ru/video/serial/231414852/season/231414785/episode/231414849?utm_source=yandex&utm_medium=organic&utm_campaign=wizard\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"PREMIER\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://avatars.mds.yandex.net/get-ott/239697/0f86e907-9531-47e9-87bd-5101a08d4e30/orig\"\n" +
            "        },\n" +
            "        \"url\": \"https://premier.one/show/9245?utm_source=yandex&utm_medium=yandex_feed_search&utm_campaign=yandex_feed\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"more.tv\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://avatars.mds.yandex.net/get-ott/1648503/97e3cbbd-40ee-4298-888d-ed2d0f022a69/orig\"\n" +
            "        },\n" +
            "        \"url\": \"https://more.tv/parallelnye_miry?utm_source=yandex-snippet&utm_medium=snippet&utm_campaign=parallelnye_miry\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Кинотеатр Wink\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://avatars.mds.yandex.net/get-ott/1672343/54096cbe-cc3b-41c9-8e44-990ebbca8d61/orig\"\n" +
            "        },\n" +
            "        \"url\": \"https://wink.ru/media_items/87735945?utm_source=yandex&utm_medium=koldunschick&utm_content=name\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Большое ТВ\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://avatars.mds.yandex.net/get-ott/2439731/17c7ebcf-41aa-48b6-9366-621a85f1307a/orig\"\n" +
            "        },\n" +
            "        \"url\": \"https://bolshoe.tv/promo/web/movie/22981?segment=yandex_feed&group=peoples&utm_campaign=ya_feed&utm_medium=ya_feed\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Kinopoisk HD\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://yastatic.net/s3/kinopoisk-frontend/hd-www/release/apple-touch-icon-180x180.png\"\n" +
            "        },\n" +
            "        \"url\": \"https://hd.kinopoisk.ru/?rt=442aa94882762a9cb68d228db4d5345a\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Kinopoisk HD\",\n" +
            "        \"logo\": {\n" +
            "          \"url\": \"https://yastatic.net/s3/kinopoisk-frontend/hd-www/release/apple-touch-icon-180x180.png\"\n" +
            "        },\n" +
            "        \"url\": \"https://hd.kinopoisk.ru/?rt=442aa94882762a9cb68d228db4d5345a\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  \"releaseYears\": [\n" +
            "    {\n" +
            "      \"start\": 2016,\n" +
            "      \"end\": 2016\n" +
            "    }\n" +
            "  ],\n" +
            "  \"top10\": null,\n" +
            "  \"top250\": null,\n" +
            "  \"deletedAt\": null,\n" +
            "  \"isSeries\": true,\n" +
            "  \"seriesLength\": 60,\n" +
            "  \"totalSeriesLength\": null\n" +
            "}"

    val movieDetails = Gson().fromJson(movieResponse, MovieInfoResponse::class.java )
}