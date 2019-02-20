package br.com.sample.basics

import java.util.*

fun main(args: Array<String>) {
    /**
     * Numbers - Literal Constants
     */
    val a = 123
    println(a)

    val b = 123L // Longs sao representados pelo L maiúsculo
    println(b)

    val c = 0x0F // Hex
    println(c)

    val d = 0b01 // Boolean
    println(d)

    val e = 123.5 // Double
    println(e)

    val f = 123.5f // Float
    println(f)

    val g = 1_000
    println(g)

    /**
     * Equality
     */
    val a1 = 10000
    println(a == a)

    /**
     * Boxing - Quando uma referencia nula é utilizada, é feito o boxing automatico para os tipos Integer, Double, etc
     */
    val boxedA1: Int? = a1
    val anotherBoxedA1: Int? = a1
    println(boxedA1 == anotherBoxedA1) // true - o método equals é chamado
    println(boxedA1 === anotherBoxedA1) // false - é verificada a referência

    /**
     * Explicit Conversions - Tipos menos nao podem ser atribuidos para tipos maiores
     */
    val someByte: Byte = 1
//    val someInt: Int = someByte // Erro de compilacao, pois é necessária uma conversao explicita
    val someInt: Int = someByte.toInt()
    println(someInt)


    /**
     * Characters
     */
    val someChar = '5'
    val isIn = if (someChar in '0'..'9') "It is in!" else "It is not in!"
    println(isIn)

    /**
     * Booleans
     */
    val someBool: Boolean = true
    println(someBool)

    /**
     * Arrays
     */
    val someArray = arrayOf(1, 2, 3, 4, 5)
    println(Arrays.toString(someArray))

    val someArray2 = Array(5, { i -> i * i })
    println(Arrays.toString(someArray2))

    val someIntArray = intArrayOf(1, 2, 3)
    println(Arrays.toString(someIntArray))
    println(someIntArray[1])

    /**
     * Strings
     */
    var someStr = "abc"
    for (s in someStr) {
        println(s)
    }
    someStr += "d"
    for (s in someStr) {
        println(s)
    }

    /**
     * String Literals
     */
    val s = "Some String \n"
    print(s)

    val s2 = """
        for (c in "foo")
            print(c)
    """
    println(s2)

    /**
     * String template
     */
    val i: Int? = 100
    println("Value of i is $i")

}