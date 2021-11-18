package br.com.sample.other

import kotlinx.coroutines.runBlocking

class MyHandler : suspend () -> Unit {
    override suspend fun invoke() {
        println("Handling...")
    }
}

private suspend fun invokeAfterMessage(handler: suspend () -> Unit) {
    println("Initial message")
    handler()
}

fun main() {
    runBlocking {
        invokeAfterMessage(MyHandler())
    }
}
