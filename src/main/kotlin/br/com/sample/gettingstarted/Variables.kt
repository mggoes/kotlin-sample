package br.com.sample.gettingstarted

/**
 * val = imutável
 * var = mutável
 */
val test = "Test"
var test2 = "Test 2"

fun main() {
    var a: Int = 1
    println(a)

    val b = 2
    println(b)

    val c: Int
    c = 3

    println(c)

    var x = 5
    x += 1
    println(x)

    println(test)
    println(test2)
}