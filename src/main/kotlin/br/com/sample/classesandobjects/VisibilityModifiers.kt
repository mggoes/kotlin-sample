package br.com.sample.classesandobjects

fun main() {
    foo()
    println(baz)
}

/**
 * O modificador private indica que essa funcao é visivel apenas dentro deste arquivo VisibilityModifiers.kt
 */
private fun foo() {
    println("foo")
}

/**
 * Por padrao funcoes, propriedade e classes tem visibilidade public, ou seja, podem ser acessados de qualquer lugar
 */
public var bar: Int = 50
    private set // Esse set so pode ser acessado dentro desse arquivo VisibilityModifiers.kt

/**
 * Modificador internal indica que a propriedade é visivel apenas dentro do mesmo modulo
 * Um modulo é um conjunto de arquivos Kotlin compilados (.kt, intellij modulo, maven project, gradle project)
 */
internal val baz = 6