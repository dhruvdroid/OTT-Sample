package com.dhruvdroid.sampleott.ui

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dhruvdroid.sampleott.R
import com.dhruvdroid.sampleott.adapter.ContentListAdapter
import com.dhruvdroid.sampleott.base.BaseActivity
import com.dhruvdroid.sampleott.data.MovieResult
import com.dhruvdroid.sampleott.data.Tray
import com.dhruvdroid.sampleott.data.TrayList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel


//
// Created by Dhruv on 23/08/20.
//
@ExperimentalCoroutinesApi
class MainActivity : BaseActivity() {

    private var totalCount = 0
    private var contentAdapter: ContentListAdapter? = null
    private lateinit var list: TrayList

    //    private val movieAdapter = MovieListAdapter()
    private val viewModel: MainViewModel by viewModel()

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        // enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)

        viewModel.movieResult.observe(this) { result ->
            when (result) {
                is MovieResult.Success -> {
                    showEmptyList(result.data)
                    setUiData(result.data)
                }

                is MovieResult.Error -> {
                    Toast.makeText(
                        this,
                        " $result.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun setUiData(data: TrayList) {
//        list = data.page.contentItems.content
//        movieAdapter.submitList(list)

        if (contentAdapter == null) {
            contentAdapter = ContentListAdapter(this, data.TestData as MutableList<Tray>)
            rvList.apply {
                // use this setting to improve performance if you know that changes
                // in content do not change the layout size of the RecyclerView
                setHasFixedSize(true)

                // assign layout manager
                layoutManager = LinearLayoutManager(context)
                // specify an viewAdapter (see also next example)
                // addItemDecoration(ListDecorator())
                adapter = contentAdapter
//                totalCount += data.trayList.size
            }
        } else {
//            totalCount += data.page.contentItems.content.size
            contentAdapter?.updateList(data.TestData as MutableList<Tray>)
        }

        setupScrollListener()
    }

    private fun showEmptyList(page: TrayList) {
        if (page.TestData.isEmpty()) {
            emptyList.visibility = View.VISIBLE
            rvList.visibility = View.GONE
        } else {
            emptyList.visibility = View.GONE
            rvList.visibility = View.VISIBLE
        }
    }

    private fun setupScrollListener() {
        val layoutManager = rvList.layoutManager as LinearLayoutManager
        rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()

                viewModel.listScrolled(visibleItemCount, lastVisibleItem, totalCount)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(
            searchManager.getSearchableInfo(componentName)
        )
        searchView.maxWidth = Int.MAX_VALUE

        // listening to search query text change
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                if (p0?.length ?: 0 > 3) {
                    contentAdapter?.filter?.filter(p0)
                } else {
                    contentAdapter?.filter?.filter("")
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                if (p0?.length ?: 0 > 3) {
                    contentAdapter?.filter?.filter(p0)
                } else {
                    contentAdapter?.filter?.filter("")
                }
                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }
}


