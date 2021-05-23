package br.com.sample.other

fun main() {
    /**
     * Declaracoes desestruturadas permitem extrair os campos dos objetos para dentro
     * de variaveis.
     *
     * Para que funcione, por convencao, a classe deve possuir as funcoes componentN()
     * que retornam os valores das propriedades. Alem disso, essas funcoes devem ser marcadas
     * com o modificador operator.
     */
    val (prop1, prop2) = Descriptor("First", "Second")
    println(prop1)
    println(prop2)

    /**
     * Como Data Classes declaram as funcoes componentN por padrao, e possivel utiliza-las
     * nas declaracoes desestruturadas.
     */
    val (item1, item2) = Info("Item 1", "Item 2")
    println(item1)
    println(item2)

    /**
     * A biblioteca padrao ja possui declaracoes de componentN para colecoes,
     * entao e possivel utilizar declaracoes desestruturadas em for loops
     */
    val map = mapOf("item1" to "Value 1", "item2" to "Value 2")
    for ((key, value) in map) {
        println("Key is $key and value is $value")
    }

    /**
     * Caso a variavel nao seja utilizada, e possivel especificar o underscore
     * para indicar que ela nao sera necessaria, dessa forma a funcao componentN
     * correspondente nao sera chamada
     */
    for ((_, value) in map) {
        println("Value is $value")
    }

    /**
     * E possivel desestruturar expressoes lambdas.
     *
     * Caso o parametro da expressao seja uma classe que possua as funcoes componentN
     * e possivel desestruturar esse objeto.
     */
    simpleDestructuringLambda { println(it) }

    // Essa expressao lambda recebe um Info, que pode ser desestruturado
    simpleDestructuringLambda { (i1, i2) ->
        println(i1)
        println(i2)
    }

    // Essa expressao lambda recebe um Info (que pode ser desestruturado) e uma String
    simpleDestructuringLambda2 { (i1, i2), s ->
        println(i1)
        println(i2)
        println(s)
    }
}

fun simpleDestructuringLambda(op: (Info) -> Unit) {
    op(Info("Item 11", "Item 22"))
}

fun simpleDestructuringLambda2(op: (Info, String) -> Unit) {
    op(Info("Item 11", "Item 22"), "Teste")
}

class Descriptor(private val firstProperty: String, private val secondProperty: String) {

    operator fun component1(): String {
        return firstProperty
    }

    operator fun component2(): String {
        return secondProperty
    }
}

data class Info(val item1: String, val item2: String)