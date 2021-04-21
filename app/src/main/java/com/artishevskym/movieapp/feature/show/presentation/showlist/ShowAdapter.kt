package com.artishevskym.movieapp.feature.show.presentation.showlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.artishevskym.movieapp.databinding.MovieListItemBinding
import com.artishevskym.movieapp.feature.show.data.network.model.ShowJson

class ShowAdapter : RecyclerView.Adapter<ShowAdapter.TvShowListItemHolder>() {

    inner class TvShowListItemHolder(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<ShowJson>() {
        override fun areItemsTheSame(oldItem: ShowJson, newItem: ShowJson): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShowJson, newItem: ShowJson): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var tvShows: List<ShowJson>
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
