package br.com.sample.classesandobjects

fun main() {
    val base: BaseInter = BaseImpl()
    val derived = DerivedImpl(base)
    derived.process()
    derived.printGreetings()
}

interface BaseInter {
    fun process()

    fun printGreetings()
}

open class BaseImpl : BaseInter {
    override fun process() {
        println("Processing")
    }

    override fun printGreetings() {
        println("Hello!")
    }
}

/**
 * O marcador by indica que o compilador gerara implementacoes para todos
 * os metodos declarados em BaseInter e delegara a chamada para o objeto base
 * recebido no construtor.
 *
 * Somente interfaces podem ser utilizadas para delegacao.
 */
class DerivedImpl(base: BaseInter) : BaseInter by base {

    /**
     * Sobrescrita funciona normalmente e o compilador nao delegara
     * essa chamada para o objeto base
     */
    override fun printGreetings() {
        println("Greetings from DerivedImpl")
    }
}