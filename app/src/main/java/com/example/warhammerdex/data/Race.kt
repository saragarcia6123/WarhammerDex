package com.example.warhammerdex.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "races")
data class Race(
    @PrimaryKey val id: Int,
    val name: String
)
