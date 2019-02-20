package br.com.sample.functionsandlambdas

fun main(args: Array<String>) {
    /**
     * Simple lambda
     */
    val sum = sum(10, 20, { num1, num2 -> num1 + num2 })
    println("Sum is ${sum}")

    /**
     * Function Types
     *
     * Sao variaveis que armazenam funcoes lambdas. Elas devem ser inicializadas antes
     * de serem utilizadas
     */
    val op1: () -> Unit

    val op2: () -> Unit = { println("Empty operation") }
    op2()
    // Ou
    op2.invoke()

    // Tipos de funcoes podem possuir parametros nomeados
    val op3: (n1: Int, String) -> String = { n1, s ->
        s + n1
    }
    println(op3(10, "Teste "))
    // Ou
    println(op3.invoke(10, "Teste "))

    // Assim como variaveis comuns, type functions podem ser nulas. Basta adicionar parenteses e especificar ?
    val op4: (() -> Unit)?
    op4 = null
    println(op4)

    // Raferencias de funcoes tambem podem ser utilizadas para passagem de parametros
    var r = lambdaTest(Int::times)
    println(r)
    // Ou
    r = lambdaTest({ n1, n2 -> n1 * n2 })
    println(r)

    /**
     * Receiver lambdas
     */
    val customRepeat: String.(Int) -> String = { times ->
        // Neste contexto this se refere ao tipo String
        this.repeat(times)
    }

    // Na chamada, o receiver type e passado primeiro, depois sao passados os parametros da funcao lambda
    println(customRepeat("Teste ", 2))
    // E possivel invocar uma funcao de tipo como se fosse uma extension function
    println("Teste ".customRepeat(2))
    // Ou
    println(customRepeat.invoke("Teste ", 2))

    val op5 = { x: Int, y: Int -> x + y }
    println(op5.invoke(10, 20))

    /**
     * Se a funcao receber apenas uam expressao lambda ou receber uma expressao lambda
     * como ultimo parametro, essa expressao pode ser passada fora dos parenteses
     */
    r = lambdaTest() { n1, n2 -> n1 * n2 }
    println(r)
    // Ou
    r = lambdaTest { n1, n2 -> n1 * n2 }
    println(r)

    /**
     * Caso a expressao lambada possua apenas um parametro e o compilador consiga
     * inferir o tipo desse parametro, e possivel omitir a declaracao desse parametro
     * e o operador ->, dessa forma, o parametro sera atribuido a variavel it
     */
    var t = simpleLambda { "First value is $it" }
    println(t)

    // Pode especificar o retorno explicitamente utilizando o return qualificado
    t = simpleLambda { return@simpleLambda "Second value is $it" }
    println(t)

    /**
     * Caso o parametro de uma expressao lambda nao for utilizado, e possivel especificar underscore
     * para ignora-lo
     */
    t = simpleLambda { _ -> "Unused parameter" }
    println(t)

    /**
     * Funcoes anonimas
     *
     * Sao funcoes semelhantes as funcoes normais, porem nao possuem nome. Elas devem ser atribuidas
     * para uma variavel
     */
    val f = fun(x: Int, y: Int): Int {
        return x * y
    }

    r = f.invoke(20, 30)
    println(r)
}

fun sum(num1: Int, num2: Int, customSum: (num1: Int, num2: Int) -> Int): Int {
    return customSum(num1, num2)
}

fun lambdaTest(f: (Int, Int) -> Int): Int {
    return f(10, 20)
}

fun simpleLambda(l: (Int) -> String): String {
    return l.invoke(30)
}