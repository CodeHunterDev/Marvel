package com.amnah.marvelapp.data.repository.domain.mapper

import com.amnah.marvelapp.data.local.entity.CharacterEntity
import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.remote.response.stories.EventsResult
import com.amnah.marvelapp.data.repository.domain.models.Characters

class CharacterMapper: IMapper<CharacterResult, EventsResult, Characters, CharacterEntity> {
    override fun map(input: CharacterResult): Characters {
        return Characters(
            id = input.id,
            name = input.name,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = null,
            creatorsName = null
        )
    }

    override fun characterEntityMap(input: CharacterResult): CharacterEntity {
        return CharacterEntity(
            id = input.id?.toLong() ?: 0L,
            name = input.name ?: "",
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }

    override fun eventsMap(input: EventsResult): Characters {
        return Characters(
            id = input.id,
            name = input.title,
            imageUrl =  "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description,
            creatorsName = input.creators?.items?.joinToString { it.name.toString() }
        )
    }


}
