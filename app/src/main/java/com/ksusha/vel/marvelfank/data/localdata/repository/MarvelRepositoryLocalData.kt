package com.ksusha.vel.marvelfank.data.localdata.repository

import androidx.lifecycle.LiveData
import com.ksusha.vel.marvelfank.data.localdata.HeroMarvel
import com.ksusha.vel.marvelfank.data.localdata.HeroesMarvelDAO
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MarvelRepositoryLocalData(private var heroesMarvelDAO: HeroesMarvelDAO) {


    fun getHeroMarvel(): LiveData<List<HeroMarvel>> {
        return heroesMarvelDAO.getAllHeroesMarvel()
    }

    fun insertHeroesMarvel(heroMarvel: HeroMarvel) {
        Observable.create<Any> {
            heroesMarvelDAO.insertHeroMarvel(
                heroMarvel
            )
        }.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun updateHeroesMarvel(heroMarvel: HeroMarvel) {
        Observable.create<Any> {
            heroesMarvelDAO.updateHeroMarvel(
                heroMarvel
            )
        }.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun deleteHeroesMarvel(heroMarvel: HeroMarvel) {
        Observable.create<Any> {
            heroesMarvelDAO.deleteHeroMarvel(
                heroMarvel
            )
        }.subscribeOn(Schedulers.io())
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    fun getAllIdHeroMarvel(): LiveData<List<String>> {
        return heroesMarvelDAO.getAllIdHeroesMarvel()
    }


}