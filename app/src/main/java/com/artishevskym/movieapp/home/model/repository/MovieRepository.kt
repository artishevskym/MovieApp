package com.artishevskym.movieapp.home.model.repository

import com.artishevskym.movieapp.home.model.api.TvMazeApi
import javax.inject.Inject

class MovieRepository
@Inject constructor(private val api: TvMazeApi) {
    suspend fun getTvShows() = api.getTvShows()
}