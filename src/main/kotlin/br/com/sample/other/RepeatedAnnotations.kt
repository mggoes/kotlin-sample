package br.com.sample.other

import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS

@Repeatable
@Target(CLASS)
@Retention(RUNTIME)
annotation class Tag(val name: String)

@Tag("simple")
@Tag("user")
data class SimpleUser(val name: String)

fun main() {
    println(SimpleUser::class.annotations)
}

