package com.amnah.marvelapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    @PrimaryKey var id: Long?,
    var name: String,
    var imageUrl: String
)
