package com.f98k.baseproject.data.service.data

sealed class RemoteResult<out T> {
    data class Success<out T>(val data: T) : RemoteResult<T>()
    data class Error(val exception: Throwable) : RemoteResult<Nothing>()
}