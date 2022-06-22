package com.ksusha.vel.marvelfank.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ksusha.vel.marvelfank.data.localdata.HeroMarvel
import com.ksusha.vel.marvelfank.data.localdata.HeroesMarvelDataBase
import com.ksusha.vel.marvelfank.data.localdata.repository.MarvelRepositoryLocalData


class FavoriteListActivityViewModel(application: Application) :
    AndroidViewModel(application) {

    private var marvelRepositoryLocalData: MarvelRepositoryLocalData

    init {
        val heroesMarvelDAO = HeroesMarvelDataBase.getInstance(application).heroesMarvelDAO()
        marvelRepositoryLocalData = MarvelRepositoryLocalData(heroesMarvelDAO)
    }


    fun getHeroes(): LiveData<List<HeroMarvel>> {
        return marvelRepositoryLocalData.getHeroMarvel()
    }

    fun getIdHeroes(): LiveData<List<String>> {
        return marvelRepositoryLocalData.getAllIdHeroMarvel()
    }

    fun insertHeroMarvel(heroMarvel: HeroMarvel?) {
        marvelRepositoryLocalData.insertHeroesMarvel(heroMarvel!!)
    }

    fun updateHeroMarvel(heroMarvel: HeroMarvel?) {
        marvelRepositoryLocalData.updateHeroesMarvel(heroMarvel!!)
    }

    fun deleteHeroMarvel(heroMarvel: HeroMarvel?) {
        marvelRepositoryLocalData.deleteHeroesMarvel(heroMarvel!!)
    }


}

