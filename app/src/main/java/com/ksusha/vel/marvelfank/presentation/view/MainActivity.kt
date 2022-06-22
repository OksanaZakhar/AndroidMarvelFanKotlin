package com.ksusha.vel.marvelfank.presentation.view

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ksusha.vel.marvelfank.data.remotedata.model.Result
import com.ksusha.vel.marvelfank.databinding.ActivityMainBinding
import com.ksusha.vel.marvelfank.presentation.adapter.ResultAdapter
import com.ksusha.vel.marvelfank.presentation.viewmodel.MainActivityViewModel
import java.security.NoSuchAlgorithmException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var results: MutableList<Result> = mutableListOf()
    private lateinit var mainActivityViewModel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        mainActivityViewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(MainActivityViewModel::class.java)

        try {
            getMarvel()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }


    }

    @Throws(NoSuchAlgorithmException::class)
    fun getMarvel() {
        mainActivityViewModel.getAllMarvelHero().observe(
            this
        ) { resultList ->
            results = resultList as MutableList<Result>
            fillRecyclerView(results)
        }

    }


    private fun fillRecyclerView(results: MutableList<Result>) {
        val recyclerView: RecyclerView = binding.recyclerView
        val adapter = ResultAdapter(this, results)
        var spanCount = 1
        spanCount = if (resources.configuration.orientation ==
            Configuration.ORIENTATION_PORTRAIT
        ) {
            2
        } else {
            3
        }
        recyclerView.layoutManager = GridLayoutManager(this, spanCount)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }


}
