package com.ksusha.vel.marvelfank.presentation.view

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ksusha.vel.marvelfank.databinding.ActivityHeroBinding
import com.ksusha.vel.marvelfank.model.Hero


class HeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroBinding
    private lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHeroBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        getHeroFromIntent()
        binding.textViewName.text = hero.name
        binding.textViewDescription.text = hero.description
        binding.textViewComics.text = hero.comics
        binding.textViewComics.movementMethod = ScrollingMovementMethod()

        Glide.with(this)
            .load(hero.imagePath)
            .into(binding.imageViewHero)

        binding.buttonAddToFavoriteList.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HeroActivity, FavoriteListActivity::class.java)
            intent.putExtra("heroId", hero.id)
            intent.putExtra("heroName", hero.name)
            intent.putExtra("heroDescription", hero.description)
            intent.putExtra("heroImagePath", hero.imagePath)
            intent.putExtra("heroComics", hero.comics)
            startActivity(intent)
        })
        binding.buttonGoToFavoriteList.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(this@HeroActivity, FavoriteListActivity::class.java)
            )
        })


    }

    private fun getHeroFromIntent() {

        val intent = intent

        if (intent != null && intent.hasExtra("dataId")) {
            hero = Hero(
                id = intent.getStringExtra("dataId").toString(),
                imagePath = intent.getStringExtra("dataImagePath").toString(),
                name = intent.getStringExtra("dataName").toString(),
                description= intent.getStringExtra("dataDescription").toString(),
                comics= intent.getStringExtra("dataComics").toString()
           )
        }

    }
}