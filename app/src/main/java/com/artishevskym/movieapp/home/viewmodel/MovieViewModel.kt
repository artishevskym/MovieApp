package com.artishevskym.movieapp.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artishevskym.movieapp.home.model.models.MovieItem
import com.artishevskym.movieapp.home.model.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieViewModel
@Inject constructor(private val repository: MovieRepository) : ViewModel() {
    private val _response = MutableLiveData<List<MovieItem>>()
    val responseTvShow: LiveData<List<MovieItem>>
        get() = _response

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() = viewModelScope.launch {
        repository.getTvShows().let { response ->
            if (response.isSuccessful) {
                Timber.d("Received shows: ${response.body()}")
                _response.postValue(response.body())
            } else {
                Timber.e("Couldn't get all TV shows. Error: ${response.code()}")
            }
        }
    }
}