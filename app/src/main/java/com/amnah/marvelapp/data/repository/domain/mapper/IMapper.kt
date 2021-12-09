package com.amnah.marvelapp.data.repository.domain.mapper

interface IMapper<CHARACTER_RESULT, EVENT_RESULT, COMICS_RESULT, CHARACTERS, CHARACTER_ENTITY> {
    fun characterMapToEntity(input: CHARACTER_RESULT): CHARACTER_ENTITY
    fun characterEntityToMap(input: CHARACTER_ENTITY): CHARACTERS
    fun characterMap(input: CHARACTER_RESULT): CHARACTERS
    fun eventsMap(input: EVENT_RESULT): CHARACTERS
    fun comicsMap(input: COMICS_RESULT): CHARACTERS

}