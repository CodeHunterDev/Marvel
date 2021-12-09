package com.amnah.marvelapp.data.repository.domain.mapper

interface IMapperCaching<CHARACTER_RESULT, CHARACTERS, CHARACTER_ENTITY> {
    fun characterMapToEntity(input: CHARACTER_RESULT): CHARACTER_ENTITY
    fun characterEntityToMap(input: CHARACTER_ENTITY): CHARACTERS
}
