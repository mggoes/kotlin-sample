package br.com.sample.other

const val TEXT = "Some Text"

fun main(args: Array<String>) {
    /**
     * Obtendo uma referencia de classe
     */
    val c = String::class
    println(c)

    val t = Test()
    println(t::class)

    /**
     * Referencia de funcoes
     */
    val f = ::someFun
    someReceiver(f)

    /**
     * Referencia de propriedades
     */
    val p = ::TEXT
    println(p.name)
    println(p.get())

    val testProp = Test::prop
    val v = testProp.get(Test("Test Property"))
    println(v)

    /**
     * Referencia de contrutor
     */
    printBuilding(::Building)
}

class Test(val prop: String = "")

fun someFun() {
    println("Some fun")
}

fun someReceiver(f: () -> Unit) {
    f.invoke()
}

class Building

fun printBuilding(factory: () -> Building) {
    val b: Building = factory()
    println(b)
}

