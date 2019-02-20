package br.com.sample.other

fun main(args: Array<String>) {
    /**
     * Em Kotlin existem dois tipos de igualdade: estrutural e
     * referencial.
     *
     * Para checar se duas variaveis possui o mesmo valor (.equals()),
     * basta utilizar o operador de igualdade ==
     *
     * Para checar se duas variaveis referenciam o mesmo objeto, basta
     * utilizar o operador ===
     *
     * O compilador traduz a chamada ao operador == para uma chamada ao
     * metodo .equals() desde que a variavel nao seja nula.
     *
     * Para tipos primitivos (Int, Long, etc), o operador === e equivalente
     * ao ==
     */
    val a = "Teste"
    val b = "Teste"
    println(a == b) // true - Chamara .equals()
    println(a != b) // false - Chamara .equals()
    println(a === b) // true
    println(a !== b) // false

    val c = EqualityTest()
    val d = EqualityTest()
    val e = c
    println(c == d) // false - Chamara .equals()
    println(c == e) // true - Chamara .equals()
    println(c === e) // true
    println(c == null) // Sera traduzido para c === null
}

class EqualityTest