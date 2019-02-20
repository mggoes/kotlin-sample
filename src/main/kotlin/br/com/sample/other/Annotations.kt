package br.com.sample.other

import kotlin.properties.Delegates

fun main() {
    /**
     * Annotations tambem podem ser aplicadas para lambdas
     */
    val l = @Expression Runnable {
        println("Test")
    }

    println(l.run())

    "Test".myExtension()
}

/**
 * Aplicando a anotacao Collect utilizando o target @receiver:
 */
fun @receiver:Collect String.myExtension() {
    println("The value of this String is $this")
}

@Metainfo
class TestAnnotation @Metainfo constructor() {

    /**
     * Quando uma anotacao e aplicada existem diversos elementos Java que podem ser gerados,
     * para especificar qual ponto a anotacao sera aplicada pode ser utilizados os prefixos
     * @field:, @get:, @param:, @file:, @property:, @set:, @receiver:, @setparam:, @delegate:
     */
    @get:Metainfo
    private val name: String by Delegates.notNull()

    /**
     * Caso mais de uma anotacao seja aplicada para o mesmo target, e possivel adicinar todas
     * de uma vez utilizando colchetes [] para evitar duplicacao de codigo.
     */
    @get:[Metainfo Collect]
    private val age: Int by Delegates.notNull()

    @Metainfo
    fun showMessage() {
        println("Hello!")
    }

    @Metainfo
    fun showMessage(@Metainfo message: String) {
        println(message)
    }

    @Metainfo
    fun appendMessage(@Metainfo message: String): String {
        val m = "$message Hello!"
        return (@Expression m)
    }
}

/**
 * Anotations em Kotlin podem possuir construtores que recebem
 * parametros de tipos primitivos, String, classes, enums, outras
 * anotacoes ou array dos tipos citados.
 *
 * Parametros de anotacoes nao podem possuir tipos nulos. (String?)
 */
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
@MustBeDocumented
annotation class Metainfo(val value: String = "")

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER
)
@Retention(AnnotationRetention.RUNTIME)
@Repeatable
@MustBeDocumented
annotation class Collect(val value: String = "")

@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@Repeatable
@MustBeDocumented
annotation class Expression(val value: String = "")

annotation class Inner(val option: Option) {

    companion object {
        fun show(option: Option) {
            println("Selected option is $option")
        }
    }

    enum class Option {
        OP1, OP2, OP3
    }
}