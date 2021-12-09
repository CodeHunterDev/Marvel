package com.amnah.marvelapp.data.repository.domain.mapper

import com.amnah.marvelapp.data.local.entity.CharacterEntity
import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult
import com.amnah.marvelapp.data.remote.response.stories.EventsResult
import com.amnah.marvelapp.data.repository.domain.models.Characters

class CharacterMapper: IMapper<CharacterResult, EventsResult, ComicsResult, Characters, CharacterEntity> {
    override fun characterMap(input: CharacterResult): Characters {
        return Characters(
            id = input.id?.toLong(),
            name = input.name,
            imageUrl =  "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }

    override fun eventsMap(input: EventsResult): Characters {
        return Characters(
            id = input.id?.toLong(),
            name = input.title,
            imageUrl =  "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description,
        )
    }

    override fun comicsMap(input: ComicsResult): Characters {
        return Characters(
            id = input.id?.toLong(),
            name = input.title,
            imageUrl =  "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description.toString()
        )
    }

    override fun characterMapToEntity(input: CharacterResult): CharacterEntity {
        return CharacterEntity(
            id = input.id?.toLong(),
            name = input.name.toString(),
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )

    }
    override fun characterEntityToMap(input: CharacterEntity): Characters {
        return Characters(
            id = input.id,
            name = input.name,
            imageUrl =  input.imageUrl,
            description = null
        )
    }
}
