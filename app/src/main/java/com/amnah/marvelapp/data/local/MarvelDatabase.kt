package com.amnah.marvelapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.amnah.marvelapp.data.local.dao.MarvelCharacterDao
import com.amnah.marvelapp.data.local.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun marvelDao(): MarvelCharacterDao

    companion object {
        private const val DATABASE_NAME = "MyMarvelDatabase"

        @Volatile
        private var instance: MarvelDatabase? = null

        fun getInstance(context: Context) =
            instance ?: synchronized(this) {
                buildDatabase(context).also {
                    instance = it
                }
            }

        fun getInstanceWithoutContext() = instance!!

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MarvelDatabase::class.java,
            DATABASE_NAME
        ).build()

    }
}