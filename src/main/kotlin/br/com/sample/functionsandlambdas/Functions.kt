package br.com.sample.functionsandlambdas

fun main(args: Array<String>) {
    sum(10, 20)
    sum2(20)

    /**
     * Named parameters. Neste caso num1 utilizara o valor default.
     *
     * Quando named parameters sao utilizados eles devem ficar depois dos valores
     * normais.
     */
    sum2(num2 = 20/*, 10*/) // Nao compila

    /**
     * Caso um parametro esteja depois de um varargs, ele deve ser declarado na forma nominal
     */
    varargsFun(10, "text 1", "text 2", num2 = 30)

    /**
     * Named parameters com varargs e preciso utilizar o operador de extensao *
     */
    varargsFun(texts = arrayOf("text 1", "text 2"))

    sum(10.1, 10.2)

    val infix = InfixTest()
    infix printMessage "Mensagem de teste de funcoes infix"

    outer("Teste")
}

/**
 * Simple function
 */
fun sum(num1: Int, num2: Int): Int {
    return num1 + num2
}

/**
 * Valores default para os parametros
 */
fun sum2(num1: Int = 0, num2: Int = 0, o: A = test()): Int {
    return num1 + num2
}

fun test(): A {
    return A()
}

/**
 * E possivel misturar parametros comuns com varargs em qualquer ordem
 * Somente um parametro pode ser marcado com varargs
 */
fun varargsFun(num1: Int = 10, vararg texts: String = arrayOf(), num2: Int = 20) {
    println(texts.forEach { println(it) })
}

/**
 * Single expression functions sao declaradas com o sinal de igualdade =
 * O tipo de retorno e opcional quando o compilador conseguir inferir pela expressao
 */
fun sum(num1: Double, num2: Double) = num1 + num2 // ou fun sum(num1: Double, num2: Double): Double = num1 + num2

open class A {
    open fun show(message: String = "Test") {
        println(message)
    }
}

class B : A() {
    /**
     * Nao compila, pois funcoes que sobrescrevem outras nao podem especificar default values
     */
//    override fun show(message: String = "Test 2") {
//        super.show(message)
//    }
}

class InfixTest {

    /**
     * Funcoes marcadas com o operador infix podem ser chamadas sem a necessidade de especificar
     * ponto ou parenteses. Ex.: obj printMessage "Test"
     *
     * Regras:
     * Infix functions devem ser funcoes de membros
     * Devem ter apenas um parametro
     * O parametro nao pode ser um varargs
     */
    infix fun printMessage(message: String) {
        println(message)
    }
}

/**
 * Nao compila pois infix functions devem ser funcoes de membros
 */
//infix fun printMessage(message: String) {
//
//}

/**
 * Em Kotlin e possivel declarar funcoes locais, ou seja, funcoes dentro de outras funcoes
 */
fun outer(message: String) {

    fun inner(suffix: String = "!"): String {
        return message + suffix
    }

    println(inner())
}