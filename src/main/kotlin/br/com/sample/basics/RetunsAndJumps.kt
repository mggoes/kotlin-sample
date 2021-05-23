package br.com.sample.basics

fun main() {
    println("Start")
    loop()

    listOf(1, 2, 3).forEach {
        if (it == 3) return@forEach
        println(it)
    }

    listOf(5, 4, 3, 2, 1).forEach fe@{
        if (it == 3) return@fe
        println(it)
    }

    println("End")
}

fun loop() {
    start@ for (i in 1..5) {
        if (i == 3) {
            break@start
        }
        println("Index is $i")
    }
}