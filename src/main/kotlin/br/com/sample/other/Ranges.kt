package br.com.sample.other

fun main(args: Array<String>) {
    val value = 5
    if (value in 1..10) {
        println("$value is in range")
    }
    println("=====================================================")

    /**
     * O compilador convertera esse loop em um for loop indexado
     * sem overhead
     */
    for (i in 1..10) {
        print("$i,")
    }
    println("\n=====================================================")

    /**
     * Intera ate 1
     */
    for (i in 4 downTo 1) {
        print("$i,")
    }
    println("\n=====================================================")

    /**
     * Intera de 5 em 5
     */
    for (i in 10 downTo 1 step 5) {
        print("$i,")
    }
    println("\n=====================================================")

    /**
     * Nao inclui o 10
     */
    for (i in 1 until 10) {
        print("$i,")
    }
    println("\n=====================================================")

    /**
     * O operador .. retorna um objeto do tipo *Progression. Ex.: IntRange,
     * LongRange, etc.
     */
    val progression = (1..10)
    println(progression.first)
    println(progression.last)
}