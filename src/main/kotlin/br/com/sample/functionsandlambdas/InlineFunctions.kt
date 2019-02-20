package br.com.sample.functionsandlambdas

/**
 * Inline functions fazem com que o compilador gere otimizacoes no codigo
 * para as chamadas dessas funcoes.
 *
 * O modificador inline permite que expressoes lambdas controlem o fluxo
 * de execucao das funcoes chamadoras.
 *
 * Inline functions nao podem chamar funcoes nao publicas (marcadas com private
 * ou internal).
 */
fun main(args: Array<String>) {
    simpleFun({ println("Inline test") }) { println("Inline test 2") }

    reifiedFun<String>()

    /**
     * Retornos nao locais
     *
     * Expressoes lambdas nao podem ter retornos nao qualificados, a nao ser que elas sejam
     * inline, neste caso e possivel aplicar o return, saindo assim, da enclosing function.
     * Esses retornos sao chamados de retornos nao locais.
     */
    testReturn {
        println("First Statement")
        return // Return da enclosing function, neste caso testReturn e main
    }

    // Nao compila, pois o parametro body da funcao f esta marcado com crossinline
//    f {
//        println("Teste")
//        return
//    }
}

/**
 * O modificador noinline faz com que o compilador nao gere otimizacoes para essa
 * expressao lambda. Neste caso, a expressao lambda op2 nao podera ter um return local.
 */
inline fun simpleFun(op1: () -> Unit, noinline op2: () -> Unit) {
    op1.invoke()
    op2.invoke()
}

inline fun testReturn(op: () -> Unit) {
    op()
    println("After lambda!") // Nao sera exibido, pois a expressao lambda passada possui um return
}

/**
 * Modificador crossinline
 *
 * Como expressoes lambdas inline podem alterar o fluxo de execucao das funcoes chamadoras
 * nao e possivel utiliza-las dentro de outro contexto alem da funcao que esta recebendo
 * a expressao como parametro. Neste caso deve-se aplicar o modificador crossinline, pois
 * ele indica que a expressao lambda nao pode alterar o fluxo de execucao.
 */
private inline fun f(crossinline body: () -> Unit) {
    val f = object : Runnable {
        override fun run() = body()
    }
}

/**
 * Modificador retified
 *
 * E possivel acessar a informacao do tipo generico utilizando o modificador retified.
 * Esse modificador so pode ser utilizado em inline functions.
 */
inline fun <reified T> reifiedFun() {
    println(T::class.java.name)
}