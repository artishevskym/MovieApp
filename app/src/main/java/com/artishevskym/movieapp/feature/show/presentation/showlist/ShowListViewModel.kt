package com.artishevskym.movieapp.feature.show.presentation.showlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artishevskym.movieapp.feature.show.data.network.model.ShowJson
import com.artishevskym.movieapp.feature.show.data.ShowRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ShowListViewModel
@Inject constructor(private val repository: ShowRepositoryImpl) : ViewModel() {
    private val _response = MutableLiveData<List<ShowJson>>()
    val responseTvShow: LiveData<List<ShowJson>>
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