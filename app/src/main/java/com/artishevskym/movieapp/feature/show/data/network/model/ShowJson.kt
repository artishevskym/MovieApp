package com.artishevskym.movieapp.feature.show.data.network.model

import com.artishevskym.movieapp.feature.show.data.network.model.ImageJson

data class ShowJson(
    val id: Int,
    val image: ImageJson,
    val name: String
)