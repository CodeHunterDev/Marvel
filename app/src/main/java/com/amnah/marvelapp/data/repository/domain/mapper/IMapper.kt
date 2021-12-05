package com.amnah.marvelapp.data.repository.domain.mapper

interface IMapper<I, O, E> {
    fun map(input: I): O
    fun characterEntityMap(input: I):E
}