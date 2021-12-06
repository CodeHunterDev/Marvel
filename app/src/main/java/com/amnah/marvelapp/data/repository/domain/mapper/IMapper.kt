package com.amnah.marvelapp.data.repository.domain.mapper

interface IMapper<CHARACTER_RESULT, EVENT_RESULT, CHARACTERS, CHARACTER_ENTITY> {
    fun map(input: CHARACTER_RESULT): CHARACTERS
    fun characterEntityMap(input: CHARACTER_RESULT): CHARACTER_ENTITY
    fun eventsMap(input: EVENT_RESULT): CHARACTERS
}