package br.com.sample.serialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/serialization-guide.md
 */
@Serializable
data class User(
    @SerialName("user_name") val name: String,
    @SerialName("user_age") val age: Int
)

fun main() {
    val user = User("Matheus", 28)
    val json = Json.encodeToString(user)
    println(json)

    val result = Json.decodeFromString<User>("""{"user_name":"Matheus","user_age":28}""")
    println(result)
}