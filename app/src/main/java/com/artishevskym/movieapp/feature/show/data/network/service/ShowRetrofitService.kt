package com.artishevskym.movieapp.feature.show.data.network.service

import com.artishevskym.movieapp.feature.show.data.network.model.ShowListJson
import retrofit2.Response
import retrofit2.http.GET

interface ShowRetrofitService {
    @GET("/shows")
    suspend fun getShowListAsync(): Response<ShowListJson>
}