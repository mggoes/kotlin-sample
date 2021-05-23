package br.com.sample.other


fun main() {
    /**
     * This qualificado
     *
     * Quando a expressao this nao e qualificada ela se refere ao
     * escopo mais interno. Para se referir aos escopos externos
     * e utilizado um qualificador
     */

    class A { // Aqui e criada a label implicita @A
        inner class B { // Aqui e criada a label implicita @B
            fun test() {
                val a = this@A
                val b = this@B
                val c = this

                val someFun = someFun@ fun String.(): Int {
                    if (this == "Teste") {
                        return this@A.hashCode()
                    }
                    return this@someFun.hashCode()
                }

                println(a)
                println(b)
                println(c)

                val i = someFun("Teste")
                val i2 = someFun("Teste 2")
                println(i.toString(16))
                println(i2.toString(16))
            }
        }
    }

    val a = A()
    println("=============> $a")

    val b = a.B()
    println("=============> $b")

    b.test()
}
