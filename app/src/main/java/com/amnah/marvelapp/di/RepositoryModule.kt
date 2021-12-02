package com.amnah.marvelapp.di

import com.amnah.marvelapp.data.remote.MarvelService
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.data.repository.MarvelRepositoryImpl
import com.amnah.marvelapp.data.repository.domain.mapper.CharacterMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providesMarvelRepository(
        apiService: MarvelService,
        characterMapper: CharacterMapper
    ): MarvelRepository {
        return MarvelRepositoryImpl(apiService, characterMapper)
    }

    @Provides
    fun providerCharacterMapper(): CharacterMapper = CharacterMapper()
}