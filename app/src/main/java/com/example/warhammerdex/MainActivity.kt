package com.example.warhammerdex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.warhammerdex.data.AppDatabase
import com.example.warhammerdex.data.ViewModelFactory
import com.example.warhammerdex.data.RaceRepository
import com.example.warhammerdex.ui.Screen
import com.example.warhammerdex.ui.screens.RacesScreen
import com.example.warhammerdex.ui.theme.WarhammerDexTheme
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(
                RaceRepository(AppDatabase.getDatabase(this))
            )
        )[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WarhammerDexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.Races.route) {
                        composable(Screen.Races.route) {
                            RacesScreen(navController)
                        }
                        composable(Screen.Factions.route) {

                        }
                    }
                }
            }
        }

    }
}

