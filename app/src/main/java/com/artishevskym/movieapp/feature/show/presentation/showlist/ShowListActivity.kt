package com.artishevskym.movieapp.feature.show.presentation.showlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.artishevskym.movieapp.databinding.HomeActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowListActivity : AppCompatActivity() {

    private lateinit var binding: HomeActivityBinding
    private val viewModel: ShowListViewModel by viewModels()
    private lateinit var movieAdapter: ShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupRv()
    }

    private fun setupRv() {
        movieAdapter = ShowAdapter()

        binding.recyclerView.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@ShowListActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.recyclerView2.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@ShowListActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        binding.recyclerView3.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(this@ShowListActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        viewModel.responseTvShow.observe(this, { tvShowsList ->
            movieAdapter.tvShows = tvShowsList
        })
    }
}