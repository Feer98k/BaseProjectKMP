package com.f98k.tipstermindcocoapods.domain.usecase

import com.f98k.tipstermindcocoapods.data.constants.RemoteConfigEnum
import com.f98k.tipstermindcocoapods.data.model.ResponseResourceCallback
import com.f98k.tipstermindcocoapods.data.repository.HomeRepository

class HomeUseCase(private val homeRepository: HomeRepository) {
   suspend fun fetchRemoteConfigData(
        remoteConfigEnum: RemoteConfigEnum,
        callback: (ResponseResourceCallback<String>) -> Unit) {

           homeRepository.getRemoteConfigData(
                remoteConfigEnum = remoteConfigEnum,
                callback = { response ->
                    when (response) {
                        is ResponseResourceCallback.Success -> {
                            callback(ResponseResourceCallback.Success(response.data.toString()))
                        }
                        is ResponseResourceCallback.Error -> {
                            callback(ResponseResourceCallback.Error(response.message, response.code))
                        }
                        is ResponseResourceCallback.Exception<*> -> {
                            callback(ResponseResourceCallback.Exception(response.message))
                        }
                    }
                }
           )
    }
}