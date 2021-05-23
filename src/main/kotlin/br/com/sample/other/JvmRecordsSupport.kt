package br.com.sample.other

/**
 * Kotlin 1.5.0 suporta JVM Records
 */
@JvmRecord
data class User(val name: String, val age: Int)

fun main() {
    println(User("Matheus", 28))
}