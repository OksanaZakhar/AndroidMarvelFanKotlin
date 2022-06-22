package com.ksusha.vel.marvelfank.data.localdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [HeroMarvel::class], version = 1, exportSchema = false)
abstract class HeroesMarvelDataBase : RoomDatabase() {

    abstract fun heroesMarvelDAO(): HeroesMarvelDAO

    companion object {
        @Volatile
        private var INSTANCE: HeroesMarvelDataBase? = null


        fun getInstance(context: Context): HeroesMarvelDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HeroesMarvelDataBase::class.java, "marvel_table"
                ).build()
                INSTANCE = instance
                return instance
            }


        }
    }
}

