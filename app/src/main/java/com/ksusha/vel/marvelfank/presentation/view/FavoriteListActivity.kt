package com.ksusha.vel.marvelfank.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ksusha.vel.marvelfank.data.localdata.HeroMarvel
import com.ksusha.vel.marvelfank.databinding.ActivityFavoriteListBinding
import com.ksusha.vel.marvelfank.presentation.adapter.HeroListAdapter
import com.ksusha.vel.marvelfank.presentation.viewmodel.FavoriteListActivityViewModel

class FavoriteListActivity : AppCompatActivity() {

    private lateinit var hero: HeroMarvel
    private lateinit var binding: ActivityFavoriteListBinding
    private lateinit var favoriteListActivityViewModel: FavoriteListActivityViewModel
    private lateinit var heroes: MutableList<HeroMarvel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteListBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        favoriteListActivityViewModel = ViewModelProvider(this)
            .get(FavoriteListActivityViewModel::class.java)



        getHeroFromIntent()
        getHeroes()

    }


    private fun getHeroes() {
        favoriteListActivityViewModel.getHeroes().observe(
            this
        ) { heroesMarvel ->
            heroes = heroesMarvel as MutableList<HeroMarvel>
            loadRecyclerView()
        }
    }


    private fun loadRecyclerView() {
        val recyclerView: RecyclerView = binding.heroRecyclerView
        val heroListAdapter = HeroListAdapter(this, heroes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = heroListAdapter
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val heroMarvelToDelete: HeroMarvel = heroes[viewHolder.adapterPosition]
                favoriteListActivityViewModel.deleteHeroMarvel(heroMarvelToDelete)
            }
        }).attachToRecyclerView(recyclerView)
    }

    private fun getHeroFromIntent() {

        val intent = intent

        if (intent != null && intent.hasExtra("heroId")) {

            hero = HeroMarvel(
                id = 0,
                heroMarvelId = intent.getStringExtra("heroId").toString(),
                imagePath = intent.getStringExtra("heroImagePath").toString(),
                name = intent.getStringExtra("heroName").toString(),
                description = intent.getStringExtra("heroDescription").toString(),
                comics = intent.getStringExtra("heroComics").toString()
            )


            favoriteListActivityViewModel.getIdHeroes().observe(
                this
            ) { strings ->
                var hasId = false
                for (s in strings) {
                    if (s == hero.heroMarvelId) {
                        hasId = true
                    }
                }
                if (!hasId) {
                    favoriteListActivityViewModel.insertHeroMarvel(hero)
                }
            }


        }

    }


}