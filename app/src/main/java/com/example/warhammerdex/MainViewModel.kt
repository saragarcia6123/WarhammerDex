package com.example.warhammerdex

import androidx.lifecycle.ViewModel
import com.example.warhammerdex.data.RaceRepository
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel (
    private val raceRepository: RaceRepository
): ViewModel() {
    fun getAllRaces() = raceRepository.getAllRaces()
}