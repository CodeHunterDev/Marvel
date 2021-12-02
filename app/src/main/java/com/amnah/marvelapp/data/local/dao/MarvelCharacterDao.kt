package com.amnah.marvelapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amnah.marvelapp.data.local.entity.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelCharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacters(item: List<CharacterEntity>)

    @Query("Select * from CharacterEntity")
    fun getCharacter(): Flow<List<CharacterEntity>>
}