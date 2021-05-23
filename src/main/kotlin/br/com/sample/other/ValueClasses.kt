package br.com.sample.other

/**
 * Kotlin 1.5.0 suporta classes inline que armazenam valor sem o custo de alocacao de objetos.
 * Agora o monificador "inline" esta depreciado em favor do modificador "value"
 */
@JvmInline
value class Password(val s: String)

fun main() {
    println(Password("12345")) // Equivalente a println("12345")
}