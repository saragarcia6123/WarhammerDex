package com.example.warhammerdex.data

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.warhammerdex.LordTemp

data class FactionTemp(
    val id: Int,
    val name: String,
    val race: Int,
    val logoId: Int,
    val lordTemp: LordTemp
)