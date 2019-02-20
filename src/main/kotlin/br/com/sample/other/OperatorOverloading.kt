package br.com.sample.other

fun main(args: Array<String>) {
    /**
     * Unary Operators
     */
    val p1 = Point(10, 20)
    /**
     * Isso e possivel pois a funcao unaryMinus foi definido para
     * a classe Point/
     */
    println(-p1)
//    println(+point) // Nao compila pois a funcao unaryPlus nao foi definida

    var p2 = Point(1, 1)
    p2++
    println(p2)

    var p3 = Point(2, 2)
    p3--
    println(p3)

    /**
     * Binary Operators
     */
    val day = Day(4)
    println(day)
    println(day + 10)
    println(day - 4)
    day *= 2
    println(day)

    val b = Bag(mutableListOf(1, 2, 3))
    b.add(4)
    b.remove(4)
    println(1 in b)
    println(10 in b)
    b(4)
    println(b)
    b(5, 6, 7)
    println(b)

    val b2 = Bag(mutableListOf(1, 2, 3))
    println(b > b2)
    b2(5, 6, 7, 8, 9)
    println(b > b2)
}

data class Point(var x: Int, var y: Int)

/**
 * Em Kotlin e possivel sobrescrever unary operators (+, -, ==, etc),
 * para isso basta criar uma funcao de membro ou uma extension function
 * marcada com o modificador operator
 */
operator fun Point.unaryMinus() = Point(-x, -y)

operator fun Point.inc() = Point(++x, ++y)

operator fun Point.dec() = Point(--x, --y)

data class Day(var value: Int) {

    operator fun plus(v: Int) = Day(value + v)

    operator fun minus(v: Int) = Day(value - v)

    operator fun timesAssign(v: Int) {
        value *= v
    }
}

data class Bag(val items: MutableList<Int> = mutableListOf()) {

    fun add(value: Int) {
        items.add(value)
    }

    fun remove(value: Int) {
        items.remove(value)
    }

    operator fun contains(value: Int) = items.contains(value)

    operator fun invoke(value: Int) = items.add(value)

    operator fun invoke(vararg values: Int) = items.addAll(values.asList())

    operator fun compareTo(b2: Bag) = items.size.compareTo(b2.items.size)
}