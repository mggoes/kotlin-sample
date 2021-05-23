package br.com.sample.classesandobjects

fun main() {
    Direction.NORTH.printPrettyName()
}

enum class Direction constructor(code: Int) : Enums {
    NORTH(1), SOUTH(2), WEST(3), EAST(4, "East");

    private lateinit var prettyName: String

    init {
        println("Code of primary constructor is $code")
    }

    constructor(code: Int, prettyName: String) : this(code) {
        println("Code of secondary constructor is $code")
        this.prettyName = prettyName
    }

    override fun printPrettyName() {
        if (this::prettyName.isInitialized) {
            println("Name is $prettyName")
        }
    }
}

interface Enums {
    fun printPrettyName()
}

