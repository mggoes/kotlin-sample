package br.com.sample.classesandobjects

fun main(args: Array<String>) {
    val c = Const()
    println(testType(c))
}

fun testType(c: Country): String = when (c) {
    is Const -> "It is Const"
    is Sum -> "It is Sum"
}

/**
 * Sealed classes são classes abstradas por padrao e devem possuir um construtor privado.
 *
 * Classes que estendem uma sealed class devem ser declaradas no mesmo arquivo .kt onde está a sealed class
 */
sealed class Country

class Const : Country()

class Sum : Country()