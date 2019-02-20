package br.com.sample.gettingstarted

fun main(args: Array<String>) {
    val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    when {
        "Item 1" in items -> println("Contains Item 1")
        "Item 10" in items -> println("Contains Item 10")
    }

    items.filter { it.split(" ")[1].toInt() > 3 }
        .sortedBy { it }
        .reversed()
        .map { it.toUpperCase() }
        .forEach { println(it) }
}