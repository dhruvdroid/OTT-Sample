package com.dhruvdroid.sampleott.adapter

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dhruvdroid.sampleott.R
import com.dhruvdroid.sampleott.data.Tray
import com.dhruvdroid.sampleott.databinding.MovieItemBinding
import com.dhruvdroid.sampleott.utilities.AppUtils

//
// Created by Dhruv on 23/08/20.
//
class ContentListAdapter(val context: Context, val list: MutableList<Tray>) :
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
            viewBinder.data = data
            if (!TextUtils.isEmpty(data.created_on)) {
                val createdOn = AppUtils.getFormattedDate(
                    data.created_on,
                    AppUtils.INPUT_PATTERN_TRANSACTION_DATE,
                    AppUtils.SERVICE_PERIOD_FORMAT
                )
                viewBinder.createdOnDate = createdOn
            } else {
                viewBinder.createdOnDate = ""
            }

            if (!TextUtils.isEmpty(data.updated_on)) {
                val updatedOn = AppUtils.getFormattedDate(
                    data.updated_on,
                    AppUtils.INPUT_PATTERN_TRANSACTION_DATE,
                    AppUtils.SERVICE_PERIOD_FORMAT
                )
                viewBinder.updatedOnDate = updatedOn
            } else {
                viewBinder.updatedOnDate = ""
            }

            Glide.with(context).load(R.drawable.test_image).into(viewBinder.moviePoster);
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.viewBinding(listFiltered[position])
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
                listFiltered = filterResults.values as MutableList<Tray>
                notifyDataSetChanged()
            }
        }
    }
}
