package br.com.sample.other


fun main() {
    /**
     * =============================================================
     * Smart automatic casts
     * =============================================================
     */
    val obj: Any = SomeCastClass()
    val str = "Test"

    if (obj is SomeCastClass) {
        println("obj is of SomeClass type")

        /**
         * Cast automatico
         */
        obj.greetings()
    }

    if (str is String) {
        println("str is a text")
    }

    if (str !is String) {
        println("str is not a text")
    }

    /**
     * O compilador e inteligente o suficiente para realizar
     * o cast automatico na expressao
     */
    if (str !is String || str.isNotBlank()) {
        println("Text is not blank")
    }

    if (str is String && str.isNotBlank()) {
        println("Text is not blank")
    }

    /**
     * =============================================================
     * Unsafe casts
     *
     * Quando o operador as e utilizado, caso o objeto seja null
     * uma excecao sera lancada, mesmo se o tipo da variavel seja
     * nullable (?)
     * =============================================================
     */
    val a: Any = "a"
    val castA: String = a as String
    println(castA)

    /**
     * =============================================================
     * Safe (nullable) casts
     *
     * Ao contrario do operador as, quando o operador as? e utilizado
     * e o valor null for passado, ele sera atribuido ao inves de lancar
     * uma excecao
     * =============================================================
     */
    val b: Any? = null
    val castB: String? = b as? String // null sera atribuido
    println(castB)
}

class SomeCastClass {

    fun greetings() {
        println("Hello from SomeClass")
    }
}
