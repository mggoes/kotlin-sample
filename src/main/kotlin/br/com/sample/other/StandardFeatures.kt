package br.com.sample.other

import kotlin.io.path.Path
import kotlin.io.path.div
import kotlin.io.path.listDirectoryEntries
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

@ExperimentalTime
fun main() {
    /**
     * 1.4.0 - E possivel misturar parametros nomeados e posicionais
     * quem qualquer lugar
     */
    fun someFunction(str: String, num: Int, sep: Char) {

    }
    someFunction("Test", num = 10, ',')

    /**
     * 1.4.0 - E possivel colocar uma virgula no final de um argumento
     * para facilitar a formatacao ou a troca de posicao dos valores
     */
    val items = listOf(
        "i1",
        "i2",
        "i3",
    )
    println(items)

    /**
     * 1.4.0 - Callable reference improvements
     */
    fun foo(n: Int = 10) {
        println("Number is $n")
    }

    fun apply(f: () -> Unit) = f()
    apply(::foo)

    /**
     * 1.4.0 - Agora e possivel utilizar break e continue dentro do when
     */
    fun test(xs: List<Int>) {
        for (x in xs) {
            when (x) {
                2 -> continue
                17 -> break
                else -> println(x)
            }
        }
    }
    test(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))

    /**
     * 1.5.0 - Unsigned types
     */
    val v1: UByte = 10u
    val v2: UShort = 10U
    val v3: UInt = 10U
    val v4: ULong = 10U

    println(v1)
    println(v2)
    println(v3)
    println(v4)

    /**
     * 1.5.0 - Upper/lower case agnostico ao locale
     */
    println("Test".uppercase())
    println("Test".lowercase())

    /**
     * 1.5.0 - Char to integer
     */
    println('1'.code)
    println('1'.digitToInt())
    println(1.digitToChar())

    /**
     * 1.5.0 - Path API
     */
    val base = Path(".")
    val sub = base / "kotlin-sample"
    println(sub.listDirectoryEntries())

    /**
     * 1.5.0 - Division and mod
     */
    println(10 % 4)
    println(10.mod(4))

    /**
     * 1.5.0 - Duration
     */
    val duration = Duration.days(1)
    println(duration)

    /**
     * 1.5.0 - Collections functions firstNotNUll
     */
    val data = listOf(null, "Item1", null, "Item3")
    println(data.firstNotNullOf { it })
    println(data.firstNotNullOfOrNull { it })

    /**
     * 1.5.0 - toBoolean strict
     */
    println("true".toBooleanStrict())
    println("True".toBooleanStrictOrNull())
}
