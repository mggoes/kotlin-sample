package br.com.sample.other

/**
 * typealias permite especificar nomes mais curtos para tipos
 */
typealias RT = RuntimeException

typealias SimpleHandler = () -> Unit

fun main() {
    println(RT::class)

    val h: SimpleHandler = {
        println("Simple Handler")
    }

    h()
}