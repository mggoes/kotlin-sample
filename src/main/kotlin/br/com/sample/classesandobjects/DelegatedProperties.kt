package br.com.sample.classesandobjects

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>) {
    val h = Holder()
    println(h.prop)
    h.prop = "test"

    println(h.lazyProp)
    println(h.lazyProp)

    println(h.name)
    h.name = "Change 1"
    h.name = "Change 2"

    println(h.name2)
    h.name2 = "Change 1"
    h.name2 = ""
    println(h.name2)

    val user = SimpleUser(mapOf("name" to "Some User name", "age" to 18), mutableMapOf("address" to "Test Address"))
    println(user.name)
    println(user.age)
    println(user.address)
    user.address = "Address 2"
    println(user.address)
}

class Holder {
    var prop: String by Delegate()

    /**
     * A funcao lazy() retorna uma instancia de Lazy<T> que e executada uma vez e guarda o valor
     * retornado. Por padrao a avaliacao da propriedade e sincronizada.
     */
    val lazyProp: String by lazy {
        println("Computed!")
        "Test"
    }

    /**
     * Esse delegate e executado depois da atribuicao do valor.
     */
    var name: String by Delegates.observable("Initial value") { prop, old, new ->
        println("Property ${prop.name} had old value $old, now is $new")
    }

    /**
     * E possivel vetar a atribuicao atraves do Delegate vetoable(), pois ele e executado antes da atribuicao.
     */
    var name2: String by Delegates.vetoable("Initial") { property, oldValue, newValue ->
        if (newValue == "") {
            println("Vetoed!")
            false
        } else {
            println("Property ${property.name} had old value $oldValue, now is $newValue")
            true
        }
    }
}

/**
 * E possivel delegar chamadas para um mapa. Neste caso os getters das propriedades delegarao a chamada
 * para o mapa utilizando o nome das propriedades como chave
 */
class SimpleUser(props: Map<String, Any?>, writableProps: MutableMap<String, Any?>) {
    val name: String by props
    val age: Int by props
    var address: String by writableProps
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("$thisRef delegated get() call of property ${property.name} to Delegate class")
        return ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef delegated set() call of property ${property.name} with value $value to Delegate class")
    }
}