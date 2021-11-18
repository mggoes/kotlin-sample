package br.com.sample.other

import kotlin.reflect.typeOf
import kotlin.time.Duration.Companion.days

fun main() {
    /**
     * Read from console
     */
//    println("Input your name:")
//    val name = readln()
//    println("Hello $name")
//
//    println("Input your age:")
//    val age = readlnOrNull()
//    println("You are $age years old")

    /**
     * Duration API
     */
    val duration = 10.days
    println(duration)

    /**
     * Type of
     */
    println(typeOf<Int>())

    /**
     * Collection builders
     */
    println(buildList {
        add(1)
        add(2)
        add(3)
    })

    /**
     * Split to sequence
     */
    "green, red , brown&blue, orange, pink&green"
        .splitToSequence("[,\\s]+".toRegex())
        .forEach { println(it) }

    /**
     * Infix compare to
     */
    println("text" compareTo "text")
}
