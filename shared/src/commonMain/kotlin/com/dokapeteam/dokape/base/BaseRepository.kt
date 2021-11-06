package com.dokapeteam.dokape.base

import co.touchlab.kermit.Logger
import com.dokapeteam.dokape.util.KotlinNativeFlowWrapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseRepository : KoinComponent {
    protected val logger by inject<Logger>()

    protected val iosCoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    protected suspend fun <T> iosGet(block: suspend () -> Flow<T>): KotlinNativeFlowWrapper<T> {
        logger.d { "iosGet invoked" }
        return KotlinNativeFlowWrapper(block())
    }
}
