package br.com.sample.basics

import br.com.sample.gettingstarted.parseInt

fun main(args: Array<String>) {
    /**
     * If - No Kotlin if é uma expressão e retorna um resultado, por isso não existe if ternário
     */
    val max = 100
    if (max > 50) println("Greater")

    // As branches do if podem ser blocos e a ultima expressao é o resultado
    val result = if (max == 100) {
        println("Equals 100")
        "Equals"
    } else {
        println("Not Equals 100")
        "Not Equals"
    }
    println(result)

    /**
     * When - Substitui o switch case das outras linguagens
     */
    when (max) {
        1 -> println("One")
        1000 -> println("A Thousand")
        2, 3, 5 -> println("Two, Three or Five") // Se muitos casos devem ser tratados de forma igual, é possível utilizar ,
        parseInt(max.toString()) -> println("A hundred String") // É possível utilizar expressões, não apenas constantes
        in 1..50 -> println("It is in range")
        is Int -> println("It is int")
        else -> {
            println("Else")
        }
    }

    // When também pode ser utilizado sem argumentos e tem o mesmo comportamento de um if-else-if
    when {
        max % 2 == 0 -> println("even")
        max % 2 != 0 -> println("odd")
    }

    /**
     * For loops
     */
    val items = intArrayOf(1, 2, 3, 4, 5)
    for (item in items) println(item)

    for (i in 1..3) {
        print(i.toString() + ",")
    }

    for (i in 6 downTo 0 step 2) println(i)

    for (i in items.indices) {
        println(items[i])
    }

    for ((index, value) in items.withIndex()) {
        println("Element $value at index $index")
    }

    /**
     * While loops
     */
    var x = 5
    while (x > 0) {
        println("X is $x")
        x--
    }

    x = 5
    do {
        println("X is $x")
        x--
    } while (x > 0)
}