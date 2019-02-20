package br.com.sample.other

fun main() {
    val v = TestInline("Teste")
    println(v)
}

/**
 * Inline Class sao classes que possuem apenas uma propriedade. Em tempo de compilacao
 * o compilador tentara otimizar ao maximo essa classe e utilizar esse valor representado
 * pela classe.
 */
inline class TestInline(val value: String)