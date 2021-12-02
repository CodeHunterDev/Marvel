package com.amnah.marvelapp.data.repository.domain.mapper

import com.amnah.marvelapp.data.remote.response.character.CharacterResult
import com.amnah.marvelapp.data.repository.domain.models.Characters

class CharacterMapper: IMapper<CharacterResult, Characters> {
    override fun map(input: CharacterResult): Characters {
        return Characters(
            id = input.id,
            name = input.name,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}"
        )
    }
}