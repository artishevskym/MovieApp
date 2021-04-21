package com.artishevskym.movieapp.feature.show.data

import com.artishevskym.movieapp.feature.show.data.network.service.ShowRetrofitService
import javax.inject.Inject

class ShowRepositoryImpl
@Inject constructor(private val api: ShowRetrofitService) {
    suspend fun getTvShows() = api.getShowListAsync()
}