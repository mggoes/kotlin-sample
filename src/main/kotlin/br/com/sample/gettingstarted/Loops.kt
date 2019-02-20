package br.com.sample.gettingstarted

fun main(args: Array<String>) {
    println("=================================================")
    forLoop()

    println("=================================================")
    forLoopWithIndex()

    println("=================================================")
    whileLoop()
}

fun forLoop() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    for (item in items) {
        println(item)
    }
}

fun forLoopWithIndex() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    for (index in items.indices) {
        println("Item at $index is ${items[index]}")
    }
}

fun whileLoop() {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    var index = 0
    while (index < items.size) {
        println("Item at $index is ${items[index]}")
        index++
    }
}