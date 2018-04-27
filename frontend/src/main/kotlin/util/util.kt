package util

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine
import kotlin.js.Promise

external fun require(module: String): dynamic

inline fun <T> jsObject(builder: T.() -> Unit): T {
    val obj: T = js("({})")
    return obj.apply {
        builder()
    }
}

inline fun js(builder: dynamic.() -> Unit): dynamic = jsObject(builder)

fun launch(block: suspend () -> Unit) {
    async(block).catch { exception -> console.log("Failed with $exception") }
}

fun <T> async(c: suspend () -> T): Promise<T> {
    return Promise { resolve, reject ->
        c.startCoroutine(object : Continuation<T> {
            override fun resume(value: T) = resolve(value)

            override fun resumeWithException(exception: Throwable) = reject(exception)

            override val context = EmptyCoroutineContext
        })
    }
}

suspend fun <T> Promise<T>.await() = suspendCoroutine<T> { c ->
    then({ c.resume(it) }, { c.resumeWithException(it) })
}