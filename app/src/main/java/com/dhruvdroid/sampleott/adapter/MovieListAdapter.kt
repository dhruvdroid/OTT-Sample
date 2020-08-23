package com.dhruvdroid.sampleott.adapter

//
// Created by Dhruv on 23/08/20.
//
//class MovieListAdapter : ListAdapter<TrayList, MovieListAdapter.MovieViewHolder>(DIFF_CHECK) {
//
//    companion object {
//        private val DIFF_CHECK = object : DiffUtil.ItemCallback<TrayList>() {
//            override fun areItemsTheSame(oldItem: TrayList, newItem: TrayList): Boolean {
//                return oldItem.trayList == newItem.id
//            }
//
//
//            override fun areContentsTheSame(oldItem: TrayList, newItem: TrayList): Boolean {
//                return oldItem == newItem
//            }
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        MovieViewHolder(
//            MovieItemBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//
//    inner class MovieViewHolder(private val viewBinder: MovieItemBinding) :
//        RecyclerView.ViewHolder(viewBinder.root) {
//
//        fun viewBinding(data: TrayList) {
////            viewBinder.title.text = data.name
////            viewBinder.movieCard.setBackgroundResource(getDrawableResource(data.posterImage))
//        }
//    }
//
//    private fun getDrawableResource(posterImage: String): Int {
//        when (posterImage) {
//            "poster1.jpg" -> {
//                return R.drawable.poster1
//            }
//            "poster2.jpg" -> {
//                return R.drawable.poster2
//            }
//            "poster3.jpg" -> {
//                return R.drawable.poster3
//            }
//            "poster4.jpg" -> {
//                return R.drawable.poster4
//            }
//            "poster5.jpg" -> {
//                return R.drawable.poster5
//            }
//            "poster6.jpg" -> {
//                return R.drawable.poster6
//            }
//            "poster7.jpg" -> {
//                return R.drawable.poster7
//            }
//            "poster8.jpg" -> {
//                return R.drawable.poster8
//            }
//            "poster9.jpg" -> {
//                return R.drawable.poster9
//            }
//            else -> {
//                return R.drawable.placeholder
//            }
//        }
//    }
//
//    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        holder.viewBinding(getItem(position))
//    }
//}
