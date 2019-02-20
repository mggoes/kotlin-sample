package br.com.sample.gettingstarted

fun main(args: Array<String>) {
    println("Hello world!")
    println("Sum1: " + sum1(10, 20))
    println("Sum2: " + sum2(10, 20))
    showSum(10, 20)
}

fun sum1(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

/**
 * O tipo Unit é o equivalente do void e pode ser omitido
 */
fun showSum(a: Int, b: Int)/*: Unit*/ {
    println("Sum of $a and $b is ${a + b}")
}