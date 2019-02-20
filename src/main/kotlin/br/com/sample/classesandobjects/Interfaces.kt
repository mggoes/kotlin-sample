package br.com.sample.classesandobjects

fun main(args: Array<String>) {
    val child = Child(10)
    child.bar()
    child.foo()
}

/**
 * Interfaces em Kotlin podem ter funcoes abstratas ou com implementacoes padrao
 */
interface Simple {

    /**
     * Uma propriedade declarada em uma interface pode ser abstrada ou possuir implementacao para os seus acessores
     *
     * Não é possível inicializar uma propriedade declarada em uma interface. Ex.: val prop: Int = 10
     */
    val prop: Int

    val prop2: String
        get() = "prop2"
//    set(value) = print(field) // Nao compila pois propriedades declaradas em interfaces nao podem ter backing field

    fun bar()

    fun foo() = println("foor in Simple $prop2")
}

/**
 * É possivel sobrescrever uma propriedade declarando o campo na classe ou no construtor
 */
class Child(override val prop: Int) : Simple {

    override fun bar() {
        println("bar in Child $prop")
    }

    override fun foo() {
        super.foo()
        println("foo in Child $prop")
    }
}