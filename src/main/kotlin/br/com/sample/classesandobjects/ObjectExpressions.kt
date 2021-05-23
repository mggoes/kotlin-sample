package br.com.sample.classesandobjects

fun main() {
    /**
     * ========================== Object Expressions ==========================
     *
     * Semelhante as classes anonimas no java. A sintaxe é declarar uma variavel com os
     * supertipos desse objeto (object : Event)
     */
    execute(object : Event {
        override fun process() {
            println("Executing process")
        }
    })

    val obj = object : Concrete(10, "Ten"), Event {
        override fun process() {
            println("Processing on variable")
        }
    }
    obj.process()
    obj.showNumber()

    /**
     * Objeto anonimo sem um supertipo
     */
    val objWithoutSuperType = object {
        fun greetings() {
            println("Hello!")
        }
    }
    objWithoutSuperType.greetings()

    /**
     * ========================== Object Declarations ==========================
     *
     * Object declarations sao semelhantes aos singletons. A invocacao e feita pelo nome
     * do objeto
     */
    TextRegistry
        .addText("Some")
        .addText("test")
        .addText("text")
        .process()

    /**
     * ========================== Companion objects ==========================
     *
     * Companion objects sao Object Declarations dentro de classes.
     * Sao marcados com a palavra chave companion.
     * Companion objects se parecem com membros estaticos, porem eles ainda estao
     * associados a uma instancia.
     */
    Loader.load() // Pode ser acessado diretamente, simulando comportamento de um membro estatico
    Loader.process()

    val loader = Loader()
    loader.load() // Chamara a funcao da instancia de Loader

    // Tem o mesmo comportamento
    SuperLoader.Companion.load()
    SuperLoader.load()
}

fun execute(event: Event) {
    event.process()
}

interface Event {
    fun process()
}

open class Concrete(private val number: Int, text: String) {

    init {
        println("Text is $text")
    }

    fun showNumber() {
        println("Number is $number")
    }
}

object TextRegistry : Event {

    private lateinit var texts: ArrayList<String>

    fun addText(text: String): TextRegistry {
        if (!this::texts.isInitialized) {
            this.texts = ArrayList()
        }
        this.texts.add(text)
        return this
    }

    override fun process() {
        println(this.texts.joinToString())
    }
}

class Loader {

    /**
     * Assim como um object declaration, companion objects podem extender outras classes.
     * Apenas um Companion Object e permitido por classe.
     */
    companion object Factory : Event {
        override fun process() {
            load()
        }

        fun load() {
            println("Loaded!")
        }
    }

    fun load() {
        println("Loaded from parent!")
    }
}

class SuperLoader {

    /**
     * Companion objects nao precisam possuir um nome. Neste caso o acesso sera
     * atraves do nome "Companion"
     */
    companion object {
        fun load() {
            println("Super loaded!")
        }
    }
}