package br.com.sample.classesandobjects

fun main(args: Array<String>) {
    "Teste".prettyPrint()

    val list = mutableListOf(1, 2, 3, 4, 5)
    list.swap(0, list.size - 1)
    println(list)

    val ex1 = Ex1()
    ex1.print()

    val ext2: Ex1? = null
    ext2.toString()

    val list2 = listOf(1, 2, 3)
    println(list2.lastIdx)
}

/**
 * Extension functions
 */
fun String.prettyPrint() {
    // this corresponde ao objeto do tipo String que possuira essa funcao
    println("==================> $this <==================")
}

fun <T> MutableList<T>.swap(firstIndex: Int, secondIndex: Int) {
    val tmp = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = tmp
}

/**
 * Caso a classe ja possua uma funcao com o mesmo nome, tipo de retorno e argumentos de uma extension function, a funcao
 * declarada na classe sempre sera utilizada
 */
class Ex1 {
    fun print() {
        println("Member")
    }
}

fun Ex1.print() {
    println("Extension")
}

/**
 * É possivel criar extension functions ate mesmo para referencias nulas. Dentro da funcao é feita a checagem do objeto
 */
fun Ex1?.toString() {
    if (this == null) println("It's NULL") else println(this.toString())
}

// Como extension properties nao possuem backing field não é possível inicializa-las, ou seja, é obrigatorio prover getters ou setters
val <T> List<T>.lastIdx: Int
    get() = this.size - 1