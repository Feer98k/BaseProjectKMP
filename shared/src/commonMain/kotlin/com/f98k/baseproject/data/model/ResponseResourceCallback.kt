package com.f98k.baseproject.data.model

sealed class ResponseResource<out T> {
    data class Success<out T>(val data: T) : ResponseResource<T>()
    data class Error(val message: String) : ResponseResource<Nothing>()
    data class Exception(val throwable: Throwable) : ResponseResource<Nothing>()
}