package br.com.sample.classesandobjects

import java.time.LocalDate

/**
 * Constantes de tempo de compilacao
 */
/*
 * São propriedades que possuem seus valores conhecidos em tempo de compilacao;
 * Nao possuem getters customizados;
 * Sao inicializadas com valores primitivos ou String;
 * Sao membros top-level ou declarados em um object
 */
const val PROP = "Some property"

fun main(args: Array<String>) {
//    val address = Address("Faria Lima", "SP")
//    val newAddress = copyAddress(address)
//    println(newAddress.street)
//    println(newAddress.state)

//    val card = Card()
//    println(card.number)
//    card.number = "123"
//    println(card.number)
//    card.number = "12345"
//    println(card.number)
//    println(card.hasNumber)

//    println(PROP)

    val service = Service()
//    service.showUrl() // Lancara excecao pois a propriedade ainda nao foi inicializada
    service.url = "www.google.com.br"
    service.showUrl()
}

/**
 * Properties and Fields
 */
fun copyAddress(address: Address): Address {
    val result = Address()
    result.street = address.street
    result.state = address.state
    return result
}

class Address() {
    var street: String? = null
    var state: String? = null

    constructor(street: String, state: String) : this() {
        this.street = street
        this.state = state
    }
}

/**
 * Getters and Setters
 */
// Por padrao, todas as propriedades declaradas com var possuem get() e set(). As propriedades declaradas com val possuem apenas get()
// O acesso as propriedades sempre sera feito atraves dos acessores
class Card {
    // Quando é preciso referenciar a propriedade dentro dos seus acessores basta utilizar a palavra chave field
    var number: String = ""
        get() {
            return if (field == "") "EMPTY" else field
        }
        set(value) {
            field = if (value == "" || value.length < 5) "INVALID" else value
        }

    // Custom get
    val hasNumber get() = this.number.isNotBlank()

    // Custom set
    var expirationDate: LocalDate? = null
        set(value) {
            if (value != null) {
                field = value
            }
        }

    // Para aplicar anotacao ou alterar o modificador dos getters ou setter basta declara-lo sem o corpo
    var customField: Any? = null
        private set
}

/**
 * Late init properties
 */
class Service {
    /*
     * Por padrao, propriedades com um tipo nao nulo devem ser inicializadas na declaracao ou no construtor.
     *
     * Para nao inicializa-as basta adicionar o modificador lateinit, isso permite que a propriedade possa
     * ser inicializada em um momento futuro (indicado para uso com injecao de dependencias).
     *
     * lateinit so pode ser aplicado para propriedades declaradas com var e que nao possuam getters e setters customizados
     */
    lateinit var url: String

    fun showUrl() {
        println(url)

        // Para chegar se uma propriedade lateinit esta inicializada basta acessar a referencia para essa propriedade
        println(this::url.isInitialized)
    }
}