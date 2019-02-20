package br.com.sample.gettingstarted

fun main(args: Array<String>) {
    // Checks if a number is in the range
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("x is in range")
    }

    // Checks if a number is out of the range
    if (20 !in 1..y + 1) {
        println("20 is not in range")
    }

    // Iterating
    for (a in 1..5) {
        println("===> $a")
    }

    for (a in 1..10 step 2) {
        println("=====> $a")
    }

    for (a in 10 downTo 4 step 2) {
        println("=======> $a")
    }
}