package br.com.sample.other

import br.com.sample.other.Contact.PhoneCall
import br.com.sample.other.Contact.TextMessage

sealed class Contact {
    data class PhoneCall(val number: String) : Contact()
    data class TextMessage(val number: String) : Contact()
    data class InstantMessage(val number: String) : Contact()
}

fun main() {
    val contact: Contact = PhoneCall("999999999")

    /*
     * Agora o compilador checa se o when é exaustivo
     */
    when (contact) {
        is PhoneCall -> println("Phone call")
        is TextMessage -> println("Text message")
    }
}
