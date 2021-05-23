package br.com.sample.other

/**
 * Kotlin 1.4.0 possibilita a conversao de SAM interfaces diretamente utilizando o
 * modificador "fun"
 */
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

fun main() {
    val isEven = IntPredicate { it.mod(2) == 0 }
    println(isEven.accept(10))
}
