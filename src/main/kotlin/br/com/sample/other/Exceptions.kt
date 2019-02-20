package br.com.sample.other

fun main(args: Array<String>) {
    /**
     * Handling an exception
     */
    try {
        basicThrow()
    } catch (e: Exception) {
        println(e.message)
        e.printStackTrace()
    } finally {
        println("Finally")
    }

    /**
     * Em Kotlin try tambem e uma expressao, dessa forma e possivel ter um valor
     * de retorno
     */
    val result = try {
        basicThrow()
        "Try"
    } catch (e: Exception) {
        "Catch"
    }
    println(result)

    /**
     * Em Koltin throw tambem e uma expressao e essa expressao retorna o tipo
     * Nothing.
     *
     * Nothing e utilizado para especificar blocos de codigo que nunca serao alcancados.
     */
    val x = null // Tem o tipo Nothing?
    println(x)
    val s: Nothing = throw IllegalAccessException("Nothing test")
}

/**
 * Em Kotlin nao existem checked exceptions, dessa forma nao e preciso
 * especificar que uma funcao lanca uma excecao.
 */
fun basicThrow() {
    throw Exception("Basic Exception")
}