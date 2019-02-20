package br.com.sample.coroutines

import kotlinx.coroutines.*

fun main() {
    /**
     * Cancel
     */
//    runBlocking {
//        val job = launch {
//            try {
//                println("I'm sleeping now...")
//                delay(60000)
//            } catch (e: CancellationException) {
//                /**
//                 * Toda co-rotina lanca uma CancellationException quando e cancelada
//                 */
//                println("Coroutine was cancelled!")
//            } finally {
//                try {
//                    /**
//                     * Quando uma co-rotina e cancelada, qualquer outra chamada para uma
//                     * co-cotina lancara uma CancellationException imediatamente
//                     */
////                    delay(1000)
//                    println("Finally delay")
//                    /**
//                     * Para executar outra co-rotina apos uma cancelamento, basta utilizar
//                     * a funcao withContext
//                     */
//                    withContext(NonCancellable) {
//                        delay(1000)
//                        println("With context delay")
//                    }
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                }
//            }
//        }
//        println("Delay a bit")
//        delay(3000)
//        println("Wake up!")
//        println("Cancelling job $job")
//        job.cancelAndJoin()
//    }

    /**
     * Timeout
     */
    runBlocking {
        try {
            withTimeout(3000) {
                println("Delaying for 5 secs...")
                delay(5000)
            }
        } catch (e: TimeoutCancellationException) {
            println("Timeout")
        }

        val result = withTimeoutOrNull(5000) {
            println("Delaying for 3 secs")
            delay(3000)
            "OK"
        }
        println(result)
    }
}