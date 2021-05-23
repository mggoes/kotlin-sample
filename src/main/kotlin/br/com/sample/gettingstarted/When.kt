package br.com.sample.gettingstarted

fun main() {
    show("Teste")
    show(null)
    show(1)
    show("Hello")
    show(1L)
}

fun show(obj: Any?) {
    val result = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a String"
        else -> "Unknown"
    }
    println("$obj is $result")
}

fun whenWithVariable(obj: Any?) {
    /**
     * E possivel capturar o alvo da expressao when em uma variavel que tera o escopo
     * restrito a expressao
     */
    val result = when (val obj2 = obj) {
        1 -> "One $obj2"
        "Hello" -> "Greeting $obj2"
        is Long -> "Long $obj2"
        !is String -> "Not a String $obj2"
        else -> "Unknown $obj2"
    }
    println("$obj is $result")
}