package com.ksusha.vel.marvelfank.data.localdata

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HeroesMarvelDAO {
    @Query("SELECT * FROM marvel_table")
    fun getAllHeroesMarvel(): LiveData<List<HeroMarvel>>

    @Query("SELECT * FROM marvel_table WHERE id ==:id")
    fun getHeroMarvel(id: Long): HeroMarvel

    @Query("SELECT heroMarvelId FROM marvel_table")
    fun getAllIdHeroesMarvel(): LiveData<List<String>>

    @Insert
    fun insertHeroMarvel(heroMarvel: HeroMarvel)

    @Update
    fun updateHeroMarvel(heroMarvel: HeroMarvel)

    @Delete
    fun deleteHeroMarvel(heroMarvel: HeroMarvel)

}