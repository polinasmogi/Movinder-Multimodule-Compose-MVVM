package com.polinasmogi.moviesapi

import com.polinasmogi.moviesapi.model.Countries
import com.polinasmogi.moviesapi.model.Doc
import com.polinasmogi.moviesapi.model.Genres
import com.polinasmogi.moviesapi.model.Logo
import com.polinasmogi.moviesapi.model.Poster

object SampleData {

    val movieA = Doc(
        id = 1,
        name = "1+1",
        description = "Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, – молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений.",
        year = 2011,
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
        shortDescription = "Аристократ на коляске нанимает в сиделки бывшего заключенного. Искрометная французская комедия с Омаром Си",
        logo = Logo(
            url = "https://avatars.mds.yandex.net/get-ott/1531675/2a0000017f0262661cde61dc260cb86f7830/orig"
        )
    )

}