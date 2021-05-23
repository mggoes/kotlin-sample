package br.com.sample.classesandobjects

fun main() {
    val user1 = User("User 1", 18)
    println(user1)

    val user2 = user1.copy(age = 21)
    println(user2)
}

/**
 * Data Classes sao classes que tem o objetivo de reter valores (DTO's, VO's, Entities)
 *
 * Devem possuir pelo menos um parâmetro no construtor primario e não podem ser open
 *
 * Por padrao, classes marcadas com data possuem equals(), hashCode(), toString() e copy() gerados automaticamente
 * para os parametros declarados no construtor primario
 */
data class User(val name: String, val age: Int) {

    // Essa propriedade nao fara parte dos membros gerados automaticamente
    val document: String = ""
}