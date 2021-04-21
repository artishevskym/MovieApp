package com.artishevskym.movieapp.home.model.api

import com.artishevskym.movieapp.home.model.models.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface TvMazeApi {
    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<MovieResponse>
}