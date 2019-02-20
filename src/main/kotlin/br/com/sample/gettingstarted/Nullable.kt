package br.com.sample.gettingstarted

fun main(args: Array<String>) {
    val x = parseInt("a")
    println(x)

    val y = parseInt("1")
    println(y)

    /**
     * Erro de compilacao pois os dois parametros sao do tipo Int? (ou seja, podem ser nulos),
     * quando na verdade deveriam ser do tipo Int
     */
//    println(x * y)

    if (x != null && y != null) {
        println(x * y)
    }
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}