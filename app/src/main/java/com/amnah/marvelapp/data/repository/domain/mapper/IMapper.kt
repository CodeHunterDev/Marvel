package com.amnah.marvelapp.data.repository.domain.mapper

interface IMapper<I, O> {
    fun map(input: I): O
}