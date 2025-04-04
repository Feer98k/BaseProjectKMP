package com.f98k.tipstermindcocoapods.data.service


import com.f98k.tipstermindcocoapods.data.service.data.RemoteResult
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import com.f98k.tipstermindcocoapods.domain.bridge.LoggerBridge

abstract class BaseApiService(private val client: HttpClient) {

    suspend fun <T> get(endpoint: String, deserializer: (String) -> T): RemoteResult<T> {
        return try {
            LoggerBridge.logInfo("GET Request → $endpoint")
            val response = client.get(endpoint)
            val body = response.bodyAsText()
            RemoteResult.Success(deserializer(body))
        } catch (e: Exception) {
            LoggerBridge.logInfo("GET Error → $endpoint → ${e.message}")
            RemoteResult.Error(e)
        }
    }
    suspend fun <T> post(endpoint: String, requestBody: Any, deserializer: (String) -> T): RemoteResult<T> {
        return try {
            LoggerBridge.logInfo("POST Request → $endpoint")
            val jsonBody = Json.encodeToString(requestBody)
            val response = client.post(endpoint) {
                contentType(ContentType.Application.Json)
                setBody(jsonBody)
            }
            val body = response.bodyAsText()
            val parsed = deserializer(body)
            RemoteResult.Success(parsed)
        } catch (e: Exception) {
            LoggerBridge.logInfo("POST Error → $endpoint → ${e.message}")
            RemoteResult.Error(e)
        }
    }
}
