package br.com.sample.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    /**
     * Coroutines sao threads leves executadas dentro de um determinado contexto. Neste caso,
     * sera executada dentro do contexto global.
     */
//    GlobalScope.launch {
//        delay(3000)
//        println("World!")
//    }
//    print("Hello, ")
//    TimeUnit.SECONDS.sleep(5)
//    println("End!")

    /**
     * Bloqueando a thread com runBlocking
     */
//    GlobalScope.launch {
//        delay(1000)
//        println("Test")
//    }
//    runBlocking {
//        println("Delaying main thread for 3 secs")
//        delay(3000)
//    }
//    println("End!")

    /**
     * Esperando uma co-rotina terminar de ser executada
     */
//    runBlocking {
//        val job = GlobalScope.launch {
//            println("Launching job...")
//            println("Delaying for 3 secs")
//            delay(3000)
//            println("Completed!")
//        }
//        println("Waiting for job to complete")
//        // Join é uma suspend function, entao deve ser chamado de dentro de uma co-rotina
//        job.join()
//        println("Job completed!")
//    }

    /**
     * Concorrencia estruturada
     *
     * Todos os builders de co-rotina adicionam um escopo para sua execucao
     */
//    runBlocking {
//        launch {
//            println("Launching and delaying for 3s...")
//            delay(3000)
//            println("Completed!")
//        }
//        println("Starting...")
//    }

    /**
     * Escopo customizado
     */
    runBlocking {
        launch {
            println("First launch")
            delay(3000)
            println("Completed first launch")
        }

        /**
         * coroutineScope cria um novo escopo e so e finalizada
         * quando todos os filhos (launched) forem completados
         */
        coroutineScope {
            launch {
                println("Second launch")
                delay(5000)
                println("Completed second launch")
            }
        }

        println("Run blocking completed")
    }

    /**
     * Suspend
     */
//    runBlocking {
//        println("Calling waitAndPrint...")
//        waitAndPrint()
//    }

//    repeat(100_000) {
//        Thread {
//            TimeUnit.MILLISECONDS.sleep(100)
//            print(".")
//        }.run()
//    }
//

//    runBlocking {
//        repeat(100_000) {
//            coroutineScope {
//                launch {
//                    delay(500)
//                    print(".")
//                }
//            }
//        }
//    }
//    TimeUnit.SECONDS.sleep(100000)
}

/**
 * Suspend functions so podem ser chamadas de dentro de uma co-rotina ou
 * outra duspend function.
 */
suspend fun waitAndPrint() {
    delay(3000)
    println("Finished!")
}