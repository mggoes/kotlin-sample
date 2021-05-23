package br.com.sample.classesandobjects

fun main() {
    val foo = Outer.Nested().foo()
    println(foo)

    val inner = Outer().Inner().foo()
    println(inner)
}

class Outer {

    private val prop = 10

    class Nested {
        fun foo() = 2
    }

    /**
     * Inner class carrega uma referencia da outer class, dessa forma é porssivel acessar seus membros
     */
    inner class Inner {
        fun foo() = prop
    }
}