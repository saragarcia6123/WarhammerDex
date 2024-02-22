package com.example.warhammerdex.di

import android.content.Context
import androidx.room.Room
import com.example.warhammerdex.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "warhammer"
    ).createFromAsset("database/warhammer.db").build()

    @Singleton
    @Provides
    fun provideRaceDao(database: AppDatabase) = database.raceDao()

}