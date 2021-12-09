package com.amnah.marvelapp.data.repository.domain.mapper

import com.amnah.marvelapp.data.local.entity.CharacterEntity
import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.repository.domain.models.Characters

class CharacterEntityMapper :
    IMapperCaching<CharacterResult, Characters, CharacterEntity> {
    override fun characterMapToEntity(input: CharacterResult): CharacterEntity {
        return CharacterEntity(
            id = input.id?.toLong(),
            name = input.name.toString(),
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description,
            modified = input.modified
        )

    }

    override fun characterEntityToMap(input: CharacterEntity): Characters {
        return Characters(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl,
            description = input.description,
            modified = input.modified

        )
    }
}
