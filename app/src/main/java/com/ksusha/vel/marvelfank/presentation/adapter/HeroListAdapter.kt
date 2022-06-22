package com.ksusha.vel.marvelfank.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ksusha.vel.marvelfank.data.localdata.HeroMarvel
import com.ksusha.vel.marvelfank.databinding.FavoriteListItemBinding

class HeroListAdapter(private val context: Context, private val heroes: MutableList<HeroMarvel>) :
    RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListViewHolder {
        val binding = FavoriteListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return HeroListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeroListViewHolder, position: Int) {
        holder.bind(heroes[position])
    }

    override fun getItemCount(): Int {
        return heroes.size
    }


    class HeroListViewHolder(favoriteListItemBinding: FavoriteListItemBinding) :
        RecyclerView.ViewHolder(favoriteListItemBinding.root) {

        private val binding = favoriteListItemBinding

        fun bind(hero: HeroMarvel) {
            binding.textViewMarvelId.text = hero.heroMarvelId
            binding.textViewName.text = hero.name
            binding.textViewDescription.text = hero.description

            Glide.with(binding.imageViewHero.context)
                .load(hero.imagePath)
                .into(binding.imageViewHero)
        }


    }

}