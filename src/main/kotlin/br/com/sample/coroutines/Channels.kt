package br.com.sample.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    /**
     * Channel e um meio de comunicacao entre co-rotinas. Com ele e possivel
     * transferir informacoes.
     */
//    val channel = Channel<Int>()
//    runBlocking {
//        launch {
//            for (i in 1..5) {
//                delay(3000)
//                channel.send(i)
//            }
//            channel.close()
//        }
////        repeat(5) {
////            println("Received ${channel.receive()}")
////        }
//        for (i in channel) {
//            println("Received $i")
//        }
//        println("Done!")
//    }

//    runBlocking {
//        val texts = produceTexts()
//        /**
//         * Existe um builder para canais para co-rotinas que pode ser utilizado para
//         * consumir elementos
//         */
//        texts.consumeEach {
//            println(it)
//        }
//    }

    /**
     * Fanout
     */
//    runBlocking {
//        val producer = produceNumbers()
//        repeat(5) {
//            launch {
//                for (i in producer) {
//                    println("Processor #$it received msg $i")
//                }
//            }
//        }
//        delay(5000)
//        producer.cancel()
//    }

    /**
     * Buffer
     */
//    runBlocking {
//        val channel = Channel<Int>(10)
//        launch {
//            repeat(100) {
//                channel.send(it)
//                delay(1000)
//            }
//        }
//
//        launch {
//            for (i in channel) {
//                println("Received $i")
//            }
//        }
//    }

    /**
     * Ticker produz elementos vazios (Unit) com um delay fixo
     */
    runBlocking {
        val ticker = ticker(delayMillis = 100, initialDelayMillis = 0)
        var nextElement = withTimeoutOrNull(1) {
            ticker.receive()
        }
        println("Next element is ready: $nextElement")

        nextElement = withTimeoutOrNull(50) {
            ticker.receive()
        }
        println("Next element is not ready: $nextElement")

        nextElement = withTimeoutOrNull(60) {
            ticker.receive()
        }
        println("Next element is ready: $nextElement")
        ticker.cancel()
    }
}

fun CoroutineScope.produceNumbers() = produce {
    var x = 1
    while (true) {
        send(x++)
        delay(100)
    }
}

/**
 * Existe um builder para canais para co-rotinas que pode ser utilizado para
 * produzir elementos
 */
fun CoroutineScope.produceTexts(): ReceiveChannel<String> = produce {
    for (i in 1..5) {
        send("Text $i")
    }
}