package com.f98k.tipstermindcocoapods.data.model

sealed class ResponseResourceCallback<T>(
    val data: T? = null,
    val message: String? = null,
    val code: String? = null
) {
    class Success<T>(data: T) : ResponseResourceCallback<T>(data)
    class Error<T>(message: String? = null, code: String? = null, data: T? = null) :
        ResponseResourceCallback<T>(data, message, code)

    class Exception<String>(message: String? = null) : ResponseResourceCallback<String>(message)
}