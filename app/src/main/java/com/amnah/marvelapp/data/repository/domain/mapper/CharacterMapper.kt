package com.amnah.marvelapp.data.repository.domain.mapper

import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.remote.response.comics.ComicsResult
import com.amnah.marvelapp.data.remote.response.series.SeriesResult
import com.amnah.marvelapp.data.remote.response.stories.EventsResult
import com.amnah.marvelapp.data.repository.domain.models.Characters

class CharacterMapper :
    IMapper<CharacterResult, EventsResult,ComicsResult , SeriesResult, Characters> {
    override fun characterMap(input: CharacterResult): Characters {
        return Characters(
            id = input.id?.toLong(),
            name = input.name,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description,
            modified = input.modified
        )
    }

    override fun eventsMap(input: EventsResult): Characters {
        return Characters(
            id = input.id?.toLong(),
            name = input.title,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description,
            modified = input.modified
        )
    }

    override fun comicsMap(input: ComicsResult): Characters {
        return Characters(
            id = input.id?.toLong(),
            name = input.title,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description.toString(),
            modified = input.modified

        )
    }

    override fun seriesMap(input: SeriesResult): Characters {
        return Characters(
            id = input.id?.toLong(),
            name = input.title,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            description = input.description.toString(),
            modified = input.modified

        )
    }
}
