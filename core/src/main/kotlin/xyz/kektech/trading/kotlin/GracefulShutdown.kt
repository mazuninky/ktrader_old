package xyz.kektech.trading.kotlin

import kotlinx.coroutines.runBlocking

inline fun gracefulShutdown(crossinline block: suspend () -> Unit) {
    Runtime.getRuntime().addShutdownHook(Thread {
        runBlocking {
            block()
        }
    })
    Thread.currentThread().join()
}
