package br.com.sample.other

/**
 * Kotlin 1.5.0 suporta sealed interface, o que possibilita que todas as implementacoes
 * sejam conhecidas em tempo de compilacao
 */
sealed interface AllFather

class FirstChild(val name: String) : AllFather

class SecondChild(val name: String) : AllFather

fun main() {
    val person: AllFather = FirstChild("Matheus")
    when (person) {
        is FirstChild -> println("First Child")
        is SecondChild -> println("Second Child")
    }
}