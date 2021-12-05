package com.amnah.marvelapp.di

import com.amnah.marvelapp.data.local.MarvelDatabase
import com.amnah.marvelapp.data.local.dao.MarvelCharacterDao
import com.amnah.marvelapp.data.remote.MarvelService
import com.amnah.marvelapp.data.repository.MarvelRepository
import com.amnah.marvelapp.data.repository.MarvelRepositoryImpl
import com.amnah.marvelapp.data.repository.domain.mapper.CharacterMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesMarvelRepository(
        apiService: MarvelService,
        characterMapper: CharacterMapper,
        characterDao: MarvelDatabase
    ): MarvelRepository {
        return MarvelRepositoryImpl(apiService, characterMapper,characterDao)
    }

    @Provides
    @Singleton
    fun providerCharacterMapper(): CharacterMapper = CharacterMapper()

    @Provides
    @Singleton
    fun providerCharacterDatabase(): MarvelCharacterDao = MarvelDatabase.getInstanceWithoutContext().marvelDao()
}