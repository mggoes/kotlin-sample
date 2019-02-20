package br.com.sample.gettingstarted

val test3: Any? = null

fun main(args: Array<String>) {
    check("Teste")
    check(test3)
}

fun check(obj: Any?) {
    if (obj is String) {
        /**
         * Depois da checagem é feito o cast automatico
         */
        println("$obj is a String and has length ${obj.length}")
    } else {
        println("$obj is not a String")
    }
}