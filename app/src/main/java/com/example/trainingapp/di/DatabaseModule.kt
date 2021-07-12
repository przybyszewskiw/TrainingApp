package com.example.trainingapp.di

import android.content.Context
import androidx.room.Room
import com.example.trainingapp.data.CurrencyDao
import com.example.trainingapp.data.CurrencyDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideCurrencyDao(context: Context): CurrencyDao {
        return Room.databaseBuilder(
            context,
            CurrencyDatabase::class.java, "currency-database"
        ).build().currencyDao()
    }
}