package com.example.trainingapp.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.trainingapp.CurrencyViewModel
import com.example.trainingapp.CurrencyViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideCurrencyViewModel(owner: ViewModelStoreOwner, factory: CurrencyViewModelFactory):
            CurrencyViewModel {
        return ViewModelProvider(owner, factory).get(CurrencyViewModel::class.java)
    }
}