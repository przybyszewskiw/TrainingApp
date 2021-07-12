package com.example.trainingapp.di

import com.example.trainingapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityModule::class, DatabaseModule::class, WebserviceModule::class,
    ViewModelModule::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}