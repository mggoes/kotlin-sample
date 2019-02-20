package br.com.sample.classesandobjects

fun main(args: Array<String>) {
//    val b1 = Box<Int>(1)
//    println(b1.value)
//
//    // Inferencia de tipo
//    val b2 = Box(2)
//    println(b2.value)
//
//    // out
//    val source = Source<String>()
//    val anySource: Source<Any> = source
//
//    // in
//    val num1 = Num<Number>()
//    val num2: Num<Double> = num1
//
//    val a1 = arrayOf(1, 2, 3)
//    val a2 = Array<Any>(3) { 1 }
//    copy(a1, a2)

    // out é utilizado para atribuir para um supertipo
    val p1 = Producer("Value")
    val p11: Producer<Any> = p1

    // in é utilizado para atribuir para um subtipo
    val c1 = Consumer<Number>()
    val c11: Consumer<Double> = c1
    c11.print(20.1)

    val array = arrayOf(1, 2, "3")
    printArray(array)
}

fun copy(from: Array<out Any>, to: Array<in Any>) {
    assert(from.size == to.size)
    for (i in from.indices) {
        to[i] = from[i]
    }
}

/**
 * Quando o tipo nao é importante é possivel utilizar a projecao *. Neste caso significa que essa funcao
 * aceita um array de qualquer tipo. A projecao * permite apenas leitura.
 */
fun printArray(array: Array<*>) {
    array.forEach { println(it) }
}

class Box<T>(t: T) {
    var value = t

    fun getSomeValue(): T {
        return value
    }
}

class Source<out T>

class Num<in T>

interface Star<T : Comparable<String>>

/**
 * Quando o tipo generico precisar ter mais de um upper bound é preciso especificar a clausula where
 */
interface Star1<T>
        where T : CharSequence,
              T : Any

class Producer<out T>(private val value: T) {

    fun getValue(): T {
        return value
    }
}

class Consumer<in T> {

    fun print(value: T) {
        println("$value")
    }
}