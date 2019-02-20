package br.com.sample.coroutines

import kotlinx.coroutines.*

fun main() {
    /**
     * Dispatcher indica onde a co-rotina sera executada, uma thread especifica, um pool de threads, etc.
     */
    runBlocking {
        launch {
            println("Running on ${Thread.currentThread().name}")
        }

        /**
         * As funcoes launch e async podem receber um objeto do tipo Dispatcher
         */
        launch(Dispatchers.Default) {
            println("Running on ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("Simple")) {
            println("Running on ${Thread.currentThread().name}")
        }

        /**
         * Combinando contextos
         */
        launch(Dispatchers.Default + CoroutineName("Some Coroutine")) {
            println("Running on ${Thread.currentThread().name}: $coroutineContext")
        }
    }
}