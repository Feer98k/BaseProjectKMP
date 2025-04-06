package com.f98k.baseproject.data.service.home

import com.f98k.baseproject.data.service.BaseApiService
import io.ktor.client.HttpClient

class HomeApiService(private val client: HttpClient) : BaseApiService(client) {

}