package br.com.sample.coroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //    val time = measureTimeMillis {
//        val one = call1()
//        val two = call2()
//        println("Called 2 functions")
//        println("Result is ${one + two}")
//    }
//    println("Took ${time}ms to execute")

    /**
     * A funcao async e parecida com lauch, podem retorna um objeto do tipo Deferred
     * que e uma promessa de resultado e tambem um Job
     */
//    val time = measureTimeMillis {
//        val one = async { call1() }
//        val two = async { call2() }
//        println("Called 2 functions")
//        println("Result is ${one.await() + two.await()}")
//    }
//    println("Took ${time}ms to execute")

    /**
     * Asyn pode receber um parametro start q indica se a funcao sera executada imediatamente
     * ou posteriormente atraves da funcao start()
     */
    val job = async(start = CoroutineStart.LAZY) { call1() }
    println("Delaying...")
    delay(3000)
    println("Starting job...")
    job.start()
    println("Result is ${job.await()}")
}

suspend fun call1(): Int {
    println("Call 1 started!")
    delay(2000)
    println("Call 1 completed!")
    return 1
}

suspend fun call2(): Int {
    println("Call 2 started!")
    delay(2000)
    println("Call 2 completed!")
    return 1
}