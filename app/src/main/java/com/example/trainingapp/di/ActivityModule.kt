package com.example.trainingapp.di

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.example.trainingapp.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActivityModule(private val activity: MainActivity) {
    @Provides
    @Singleton
    fun providesContext(): Context = activity

    @Provides
    @Singleton
    fun providesViewModelStoreOwner() : ViewModelStoreOwner = activity
}