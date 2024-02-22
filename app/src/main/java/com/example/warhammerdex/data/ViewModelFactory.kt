package com.example.warhammerdex.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.warhammerdex.MainViewModel

class ViewModelFactory(
    private val raceRepository: RaceRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(raceRepository = raceRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel classs")
    }
}