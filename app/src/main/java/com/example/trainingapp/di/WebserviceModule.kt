package com.example.trainingapp.di

import com.example.trainingapp.webservice.ServiceBuilder
import com.example.trainingapp.webservice.Webservice
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WebserviceModule {
    @Provides
    @Singleton
    fun provideWebservice(): Webservice {
        return ServiceBuilder.buildService(Webservice::class.java)
    }
}