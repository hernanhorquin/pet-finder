package com.example.petfinder.di

import com.example.petfinder.data.repository.PetRepository
import com.example.petfinder.data.repository.PetRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class DataModule {

    @Binds
    abstract fun bindPetRepository(repositoryImpl: PetRepositoryImpl): PetRepository
}