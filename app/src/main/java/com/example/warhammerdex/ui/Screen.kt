package com.example.warhammerdex.ui

sealed class Screen(
    val route: String
) {
    data object Races: Screen(
        route = "races"
    )
    data object Factions: Screen(
        route = "factions"
    )
    data object Lords: Screen(
        route = "lords"
    )

}