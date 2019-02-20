package br.com.sample.classesandobjects

fun main(args: Array<String>) {
//    constructors()
//    instances()
//    override()
//    propertyOverride()
//    Derived("hello", "world")
//    Bar().Baz().g()
    SomeClassB().fun1()
}

/**
 * Construtores
 **/
fun constructors() {
    TestOrder("Hello!")
    SomeClass1("Test")
    SomeClass2("Name", "Test")
    SomeClass3("p1", "p2")
    SomeClass4()
}

/**
 * Instancias
 **/
fun instances() {
    val invoice = Invoice()
    println(invoice)

    val person = Person("Test")
    println(person)
}

/**
 * Override
 **/
fun override() {
    val someClass10 = SomeClass10()
    someClass10.method()
}

/**
 * Override de propriedades
 **/
fun propertyOverride() {
    SomeClass12().test()
}

/**
 * Classes
 **/
class Invoice {

}

// Caso a classe não possua headers e nem body as chaves podem ser emitidas
class Empty

/**
 * Construtores primarios
 **/
// Uma classe pode ter um construtor primario e um, ou mais, construtores secundarios
// Um construtor primario nao pode ter nenhum codigo
class Person constructor(firstName: String) {

}

// Se o construtor não possuir nenhuma anotacao ou modificador de visibilidade a palavra chave constructor pode ser omitida
class Animal(type: String) {

}

// As propriedades declaradas no construtor primario podem ser mutaveis ou imutaveis
class AnotherPerson(val firstName: String, var lastName: String) {

}

// Se o construtor possuir anotacoes ou modificadores de visibilidade a palavra constructor é obrigatoria
class SomeClass @Suppress private constructor(property: String) {

}

/**
 * Blocos de inicializacao
 **/
// Durante a instanciacao os blocos de inicializacao sao executados na ordem que eles aparecem, com intervalos das propriedades
// As propriedades declaradas no construtor primario podem ser utilizadas pelas propriedades e pelos blocos de inicializacao
/*
 * A saída do console será:
 *
 * First initializer Hello!
 * Some property Hello!
 * Second initializer Hello!
 */
class TestOrder(name: String) {

    init {
        println("First initializer $name")
    }

    val someProperty = "Some property $name".also(::println)

    init {
        println("Second initializer $name")
    }
}

/**
 * Construtores secundarios
 **/
class SomeClass1 {

    constructor(param: String) {
        println(param)
    }
}

// Se a classe possuir um construtor primario, cada construtor secundario precisa delegar a chamada para o construtor primario
class SomeClass2 constructor(param: String) {

    // Chamando o construtor primario atraves do this
    constructor(firstName: String, lastName: String) : this(firstName) {
        println("$firstName $lastName")
    }
}

// Blocos de inicializacao fazem parte do construtor primario, entao mesmo quando ocorre a delegacao esses blocos sao executados
class SomeClass3(param1: String) {

    init {
        println("Init block =========> $param1")
    }

    constructor(param1: String, param2: String) : this("$param1 called by secondary constructor") {
        println("=========> $param1")
        println("=========> $param2")
    }
}

// Se todos os parametros do construtor primario possuirem valor default, o compilador gerara um construtor sem parametros que chamara esse construtor primario
class SomeClass4(customerName: String = "Default name") {
    init {
        println(customerName)
    }
}

/**
 * Heranca
 **/
// Toda classe em kotlin tem uma superclasse em comum chamada Any
// Por padrao toda classe em Kotlin é final, o modificador open permite que a classe possa ser estendida
open class SomeClass5(param: String) {

    init {
        println(param)
    }
}

class SomeClass6 : SomeClass5("Some value") {

}

// Caso a classe nao possua um construtor primario, cada construtor secundario devera chamar o construtor primario da classe base utilizando super
class SomeClass7 : SomeClass5 {

    constructor() : super("Some value") {
        println("Called after constructor on base class")
    }
}

// Caso a classe possua um construtor primario, é obrigatorio a chamada ao construtor primario da classe base
class SomeClass8(param: String) : SomeClass5(param) {

    constructor() : this("Some value") {
        println("Called after constructor on base class")
    }
}

/**
 * Override
 **/
open class SomeClass9 {

    open fun method() {
        println("Method on SomeClass9")
    }

    fun method2() {}
}

class SomeClass10 : SomeClass9() {

    // Para fazer sobrescrita é preciso adicionar a anotacao override
    // Um membro com modificador override por padrao é open, para impedir a sobrescrita dessa funcao basta utilizar o modificador final
    override fun method() {
        println("Method on SomeClass10")
    }
}

/**
 * Override de propriedades
 **/
open class SomeClass11 {
    open val x: Int = 10
}

class SomeClass12 : SomeClass11() {
    override val x: Int = 20

    fun test() {
        println(x)
    }
}

// Ordem de inicializacao
/*
 * Argument for Base: Hello
 * Initializing Base
 * Initializing size in Base: 5
 * Initializing Derived
 * Initializing size in Derived: 10
 */
open class Base(val name: String) {

    init {
        println("Initializing Base")
    }

    open val size: Int = name.length.also { println("Initializing size in Base: $it") }
}

class Derived(name: String, lastName: String) :
    Base(name.capitalize().also { println("Argument for Base: $it") }) {

    init {
        println("Initializing Derived")
    }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

/**
 * Chamando superclasse
 **/
open class Foo {
    open val x: Int get() = 1

    open fun f() {
        println("f() on Foo")
    }
}

class Bar : Foo() {
    override val x = 50

    override fun f() {
        super.f()
        println("f() on Bar")
    }

    inner class Baz {
        fun g() {
            println("g() on Baz")
            super@Bar.f()
            println("${super@Bar.x} on Bar")
        }
    }
}

open class SomeClassA {
    open fun fun1() {
        println("fun1() on SomeClassA")
    }

    open fun fun2() {
        println("fun2() on SomeClassA")
    }
}

// Por padrao todos os membros de uma interface são open
interface SomeInterface {
    fun fun1() {
        println("fun1() on SomeInterface")
    }

    fun fun3() {
        println("fun3() on SomeInterface")
    }
}

class SomeClassB : SomeClassA(), SomeInterface {

    // Quando um classe é derivada de varias classes que possuem o mesmo membro é preciso remover essa ambiguidade declarando esse membro
    override fun fun1() {
        println("fun1() on SomeClassB")

        // Para chamar as funcoes das superclasses resolvendo a ambiguidade
        super<SomeClassA>.fun1()
        super<SomeInterface>.fun1()
    }
}

/**
 * Classe abstrata
 **/
abstract class BaseClass {
    abstract fun f()
}

class ClassImpl : BaseClass() {
    override fun f() {
        println("f() on ClassImpl")
    }
}