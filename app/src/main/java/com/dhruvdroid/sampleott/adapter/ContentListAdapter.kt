package com.dhruvdroid.sampleott.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.dhruvdroid.data.Content
import com.dhruvdroid.sampleott.R
import com.dhruvdroid.sampleott.databinding.MovieItemBinding

//
// Created by Dhruv on 15/08/20.
//
class ContentListAdapter(val list: MutableList<Content>) :
    RecyclerView.Adapter<ContentListAdapter.MovieViewHolder>(), Filterable {

    private var listFiltered: MutableList<Content>

    init {
        listFiltered = list
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

        fun viewBinding(data: com.dhruvdroid.data.Content) {
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
        holder.viewBinding(listFiltered.get(position))
    }

    override fun getItemCount(): Int {
        return listFiltered.size
    }

    fun updateList(content: List<com.dhruvdroid.data.Content>) {
        this.list.addAll(content)
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter? {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                listFiltered = if (charString.isEmpty()) {
                    list
                } else {
                    val filteredList: MutableList<com.dhruvdroid.data.Content> = ArrayList()
                    for (item in list) {
                        if (item.name.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(item)
                        }
                    }
                    filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = listFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                listFiltered = filterResults.values as MutableList<com.dhruvdroid.data.Content>
                notifyDataSetChanged()
            }
        }
    }

}
