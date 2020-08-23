package com.dhruvdroid.sampleott.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.dhruvdroid.sampleott.data.Tray
import com.dhruvdroid.sampleott.databinding.MovieItemBinding

//
// Created by Dhruv on 23/08/20.
//
class ContentListAdapter(val list: MutableList<Tray>) :
    RecyclerView.Adapter<ContentListAdapter.MovieViewHolder>(), Filterable {

    private var listFiltered: MutableList<Tray>

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

        fun viewBinding(data: Tray) {
//            viewBinder.title.text = data.name
//            viewBinder.movieCard.setBackgroundResource(getDrawableResource(data.posterImage))
            viewBinder.data = data
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.viewBinding(listFiltered[position])
        holder
    }

    override fun getItemCount(): Int {
        return listFiltered.size
    }

    fun updateList(content: List<Tray>) {
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
                    val filteredList: MutableList<Tray> = ArrayList()
//                    for (item in list) {
//                        if (item.trayList.get().toLowerCase().contains(charString.toLowerCase())) {
//                            filteredList.add(item)
//                        }
//                    }
                    filteredList
                }

                val filterResults = FilterResults()
                filterResults.values = listFiltered
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                listFiltered = filterResults.values as MutableList<Tray>
                notifyDataSetChanged()
            }
        }
    }

}
