package br.com.sample.coroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.runBlocking
import java.util.*

fun main() {
    runBlocking {
        /**
         * Launch e actor propagam a excecao, que por sua vez e capturada
         * pelo Thread.defaultUncaughtExceptionHandler
         */
//        val job = GlobalScope.launch {
//            println("Throwing RuntimeException from launch")
//            throw RuntimeException()
//        }
//        job.join()
//
//        /**
//         * Ja async delega a captura da excecao para o usuario
//         */
//        val deferred = GlobalScope.async {
//            println("Throwing RuntimeException from async")
//            throw RuntimeException()
//        }
//        try {
//            deferred.await()
//        } catch (e: RuntimeException) {
//            println("Caught RuntimeException")
//        }

        /**
         * E possivel definir um ExceptionHandler global para co-rotinas
         */
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Error =================> $exception with suppressed ${Arrays.toString(exception.suppressed)}")
        }
//        val job = GlobalScope.launch(handler) {
//            println("Throw exception from launch")
//            throw RuntimeException()
//        }
//        /**
//         * Aqui o handler nao fara efeito ate a chamada a funcao await
//         */
//        val deferred = GlobalScope.async(handler) {
//            println("Throw exception from async")
//            throw RuntimeException()
//        }
//        joinAll(job, deferred)

        /**
         * Quando mais de uma co-rotina filha lanca excecao, apenas a primeira e exposta para o pai.
         *
         * E possivel obter as outras excecoes lancadas consultando as excecoes suprimidas (exception.suppressed)
         */
//        val job = GlobalScope.launch(handler) {
//            launch {
//                println("Throw exception from launch 1")
//                delay(100)
//                throw ArithmeticException()
//            }
//            launch {
//                println("Throw exception from launch 2")
//                delay(100)
//                throw IllegalStateException()
//            }
//            delay(Long.MAX_VALUE)
//        }
//        job.join()

        /**
         * Com SupervisorJob e possivel supervisionar a execucao das co-rotinas filhas.
         *
         * Com ele, as excecoes lancadas pelas co-rotinas filhas nao serao propagadas para o pai
         * ou para as outras.
         *
         * Porem, as co-rotinas filhas mantem o tracking do supervisor, ou seja, caso o supervisor seja
         * cancelado, todas as co-rotinas filhas em execocao tambem sao canceladas.
         */
        val supervisor = SupervisorJob()
//        with(CoroutineScope(coroutineContext + supervisor)) {
//            val firstChild = launch(handler) {
//                println("First Child is failing")
//                throw IllegalStateException()
//            }
//            val secondChild = launch(handler) {
//                firstChild.join()
//                println("Firts child is cancelled? ${firstChild.isCancelled}, but second one is still active")
//                try {
//                    delay(10000)
//                } finally {
//                    println("Second child is cancelled because supervisor is cancelled")
//                }
//            }
//            firstChild.join()
//            println("Cancelling supervisor")
//            supervisor.cancel()
//            secondChild.join()
//        }

//        supervisorScope {
//            val firstChild = launch(handler) {
//                println("First Child is failing")
//                throw IllegalStateException()
//            }
//            val secondChild = launch(handler) {
//                firstChild.join()
//                println("First child is cancelled? ${firstChild.isCancelled}, but second one is still active")
//                try {
//                    delay(3000)
//                } finally {
//                    println("Second child is cancelled because supervisor is cancelled")
//                }
//            }
//            firstChild.join()
//            println("Cancelling supervisor")
//            supervisor.cancel()
//            secondChild.join()
//        }
    }
}