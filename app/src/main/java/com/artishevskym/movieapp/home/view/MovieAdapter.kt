package com.artishevskym.movieapp.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.artishevskym.movieapp.databinding.MovieListItemBinding
import com.artishevskym.movieapp.home.model.models.MovieItem

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.TvShowListItemHolder>() {

    inner class TvShowListItemHolder(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<MovieItem>() {
        override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var tvShows: List<MovieItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowListItemHolder {
        return TvShowListItemHolder(
            MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TvShowListItemHolder, position: Int) {
        val currentTvShow = tvShows[position]

        holder.binding.apply {
            textView.text = currentTvShow.name
            imageView.load(currentTvShow.image.original) {
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = tvShows.size
}
