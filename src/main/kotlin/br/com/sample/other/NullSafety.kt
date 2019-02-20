package br.com.sample.other

import java.time.LocalDate

fun main(args: Array<String>) {
    /**
     * Em Kotlin nao e possivel executar funcoes ou acessar membros explicitamente de
     * referencias que podem ser nulas
     */
    var a: String = "Teste"
//    a = null // Erro de Compilacao
    println(a)

    var b: String? = "Teste 2"
    b = null // OK
    println(b)
//    b.length // Erro de compilacao

    /**
     * Para acessar funcoes ou membros de referencias que podem ser nulas e preciso
     * executar uma checagem antes, dessa forma o compilador verificara essa checagem
     * e permitira a chamada do membro
     */
    if (b != null) {
        println("Variable b is not null and has ${b.length}")
    }

    /**
     * Safe Calls
     *
     * Para acessar membros de variaveis que podem ser nulas e possivel utilizar
     * o operador ?.
     *
     * O membro so sera acessado se a variavel nao for nula, caso contrario, null
     * sera retornado
     */
    var c: String? = "Teste 3"
    println(c?.length) // Imprimira 7
    c = null
    println(c?.length) // Imprimira null
    c = "Teste 3"
    c?.let {
        println("Variable $it is not null")
    }

    /**
     * E possivel utilizar o operador de chamada segura tambem em atribuicoes
     */
    val e1 = Employer("Employer 1", null)
    e1.data?.birth = LocalDate.now() // O valor so sera atribuido se a variavel data nao for nula
    e1.data?.job = "Manager" // O valor so sera atribuido se a variavel data nao for nula
    println(e1)

    e1.data = EmployerData()
    e1.data?.birth = LocalDate.now() // O valor so sera atribuido se a variavel data nao for nula
    e1.data?.job = "Manager" // O valor so sera atribuido se a variavel data nao for nula
    println(e1)

    /**
     * Elvis Operator
     *
     * O operador elvis (?:) devolve o valor do lado esquerdo se o mesmo nao for nulo,
     * caso contrario, o valor do lado direito e avaliado e devolvido.
     *
     * O operador elvis e semelhante a expressao ternaria em Java (x != null) ? x : y
     */
    var o: String? = "Teste"
    var o2 = o ?: "Teste 2"
    println(o2) // Imprimira Teste
    o = null
    o2 = o ?: "Teste 2"
    println(o2) // Imprimira Teste 2

    /**
     * !! Operator
     *
     * Esse operador e utilizado para lancar uma NullPointerException explicitamente.
     * Ele converte qualquer valor para um valor nao nulo, caso a variavel seja nula,
     * uma KotlinNullPointerException sera lancada. Dessa forma e possivel lancar uma
     * NullPointerException explicitamente quando desejado.
     */
    var d: String? = "Teste"
    println(d!!.length)
    d = null
    println(d!!.length)
}

data class Employer(val name: String?, var data: EmployerData?)

data class EmployerData(var birth: LocalDate?, var job: String?) {
    constructor() : this(null, null)
}