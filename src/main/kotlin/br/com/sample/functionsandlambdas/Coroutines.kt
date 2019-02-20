//package br.com.sample.functionsandlambdas
//
//import java.util.concurrent.TimeUnit
//import kotlin.coroutines.experimental.buildSequence
//
///**
// * Coroutines sao rotinas que facilitam a programacao assincrona e encapsulam
// * a logica e complexidade desse paradigma.
// *
// * O compilador realiza otimizacoes para que o metodo seja executado de forma
// * lazy.
// */
//fun main(args: Array<String>) {
//    val seq = buildSequence {
//        println("Start")
//        var count = 0
//        while (count < 10) {
//            println("Count ${count++}") // Sera impresso apenas Count 0, Count 1, Count 2 pois foi requisitado apenas 3 items (seq.take(3))
//            yield(count)
//        }
//        println("End")
//    }
//    println("Outside buildSequence")
//    /**
//     * Sera impresso:
//     *
//     * Outside buildSequence
//     * Start
//     * Count 0
//     * 1
//     * Count 1
//     * 2
//     * Count 2
//     * 3
//     *
//     * Pois a execucao acontecera de forma lazy
//     */
//    println(seq.take(3).forEach { println(it) })
//}
//
///**
// * Modificador suspend
// *
// * O modificador suspend e utilizado para indicar que a funcao sera executada de forma
// * assincrona. Funcoes com esse modificador so podem ser chamadas de dentro de
// * co-rotinas.
// */
//suspend fun testSuspend() {
//    TimeUnit.SECONDS.sleep(5)
//    println("Done!")
//}