package com.example.warhammerdex.data

import androidx.room.Dao
import androidx.room.Query

@Dao
interface RaceDao {

    @Query("SELECT * FROM races")
    fun readAll(): List<Race>

}