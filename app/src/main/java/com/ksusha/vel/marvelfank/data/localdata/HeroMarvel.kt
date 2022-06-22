package com.ksusha.vel.marvelfank.data.localdata

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "marvel_table")
class HeroMarvel(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var heroMarvelId: String,
    var imagePath: String,
    var name: String,
    var description: String,
    var comics: String
)
