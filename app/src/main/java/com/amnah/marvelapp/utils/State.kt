package com.amnah.marvelapp.utils

sealed class State<out T>(val data: T?) {

    class Success<T>(data: T) : State<T>(data)
    class Error(val throwable: Throwable) : State<Nothing>(null)
    object Loading : State<Nothing>(null)

    override fun toString(): String {
        return when (this) {
            is Success -> "Success: $data"
            is Error -> "Error: ${throwable.message}"
            Loading -> "Loading"
        }
    }
}
