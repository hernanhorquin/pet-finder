package com.example.petfinder.di

import com.example.petfinder.data.PetRequestGenerator
import com.example.petfinder.data.api.PetApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun provideRetrofitApiClient(): PetRequestGenerator {
        return PetRequestGenerator()
    }

}