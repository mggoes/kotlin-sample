package br.com.sample.other

/**
 * typealias permite especificar nomes mais curtos para tipos
 */
typealias RT = RuntimeException

typealias SimpleHandler = () -> Unit

fun main(args: Array<String>) {
    println(RT::class)

    val h: SimpleHandler = {
        println("Simple Handler")
    }

    h()
}