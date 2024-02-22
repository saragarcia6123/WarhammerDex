package com.example.warhammerdex.data

import javax.inject.Inject

class RaceRepository @Inject constructor(
    private val appDatabase: AppDatabase
) {
    fun getAllRaces() = appDatabase.raceDao().readAll()
}