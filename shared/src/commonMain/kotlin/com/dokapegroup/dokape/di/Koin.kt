package com.dokapegroup.dokape.di

import co.touchlab.kermit.LoggerConfig
import com.dokapegroup.dokape.Constants
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = false, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule(enableNetworkLogs = enableNetworkLogs), platformModules())
    }

// called by iOS etc
fun initKoin() = initKoin(enableNetworkLogs = false) {}

fun commonModule(enableNetworkLogs: Boolean) = module {
    single { createJson() }
    single { createHttpClient(get(), enableNetworkLogs = enableNetworkLogs) }
    single { co.touchlab.kermit.Logger(LoggerConfig.default) }
}

fun createHttpClient(json: Json, enableNetworkLogs: Boolean) = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer(json)
    }
    installTimeout()
    installResponseObserver { response ->
        co.touchlab.kermit.Logger.d { response.toString() }
    }
    installDefaultRequest()
    if (enableNetworkLogs) {
        installLogging { message ->
            co.touchlab.kermit.Logger.d { message }
        }
    }

}

private fun createJson() = Json {
    prettyPrint = true
    isLenient = true
    ignoreUnknownKeys = true
}

fun HttpClientConfig<*>.installLogging(block: (String) -> Unit) = install(Logging) {
    logger = createLogger(block)
    level = LogLevel.ALL
}

private fun createLogger(block: (String) -> Unit) = object : Logger {
    override fun log(message: String) = block(message)
}

fun HttpClientConfig<*>.installTimeout() = install(HttpTimeout) {
    connectTimeoutMillis = Constants.TIMEOUT
    socketTimeoutMillis = Constants.TIMEOUT
    requestTimeoutMillis = Constants.TIMEOUT
}

fun HttpClientConfig<*>.installResponseObserver(onResponse: suspend (HttpResponse) -> Unit) =
    install(ResponseObserver) {
        onResponse(onResponse)
    }

fun HttpClientConfig<*>.installDefaultRequest() = install(DefaultRequest) {
    header(HttpHeaders.ContentType, ContentType.Application.Json)
}
