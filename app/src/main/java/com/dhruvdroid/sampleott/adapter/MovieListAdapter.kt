package com.dhruvdroid.sampleott.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dhruvdroid.sampleott.R
import com.dhruvdroid.sampleott.data.Content
import com.dhruvdroid.sampleott.databinding.MovieItemBinding

//
// Created by Dhruv on 15/08/20.
//
class MovieListAdapter : ListAdapter<Content, MovieListAdapter.MovieViewHolder>(DIFF_CHECK) {

    companion object {
        private val DIFF_CHECK = object : DiffUtil.ItemCallback<Content>() {
            override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
                return oldItem.id == newItem.id
            }


            override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    inner class MovieViewHolder(private val viewBinder: MovieItemBinding) :
        RecyclerView.ViewHolder(viewBinder.root) {

        fun viewBinding(data: Content) {
            viewBinder.title.text = data.name
            viewBinder.movieCard.setBackgroundResource(getDrawableResource(data.posterImage))
        }
    }

    private fun getDrawableResource(posterImage: String): Int {
        when (posterImage) {
            "poster1.jpg" -> {
                return R.drawable.poster1
            }
            "poster2.jpg" -> {
                return R.drawable.poster2
            }
            "poster3.jpg" -> {
                return R.drawable.poster3
            }
            "poster4.jpg" -> {
                return R.drawable.poster4
            }
            "poster5.jpg" -> {
                return R.drawable.poster5
            }
            "poster6.jpg" -> {
                return R.drawable.poster6
            }
            "poster7.jpg" -> {
                return R.drawable.poster7
            }
            "poster8.jpg" -> {
                return R.drawable.poster8
            }
            "poster9.jpg" -> {
                return R.drawable.poster9
            }
            else -> {
                return R.drawable.placeholder
            }
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.viewBinding(getItem(position))
    }
}
