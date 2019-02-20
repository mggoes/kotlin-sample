package br.com.sample.gettingstarted

fun main(args: Array<String>) {
    println("max of 10 and 20 is ${maxOf(10, 20)}")
    println("max of 20 and 30 is ${max(20, 30)}")
}

fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun max(a: Int, b: Int) = if (a > b) a else b