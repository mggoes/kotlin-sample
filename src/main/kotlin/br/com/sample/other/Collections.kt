package br.com.sample.other

/**
 * Em Kotlin ha uma separacao entre colecoes mutaveis e imutaveis.
 */
fun main(args: Array<String>) {
    val nums: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)
    println(nums)

    val readOnlyNums: List<Int> = nums
    println(readOnlyNums)

    nums.add(6)
    println(readOnlyNums)
    println(readOnlyNums.get(1))
    // Ou
    println(readOnlyNums[0])

    val m: Map<Int, String> = mapOf(1 to "Item 1")
    println(m)
    println(m.get(1))
    // Ou
    println(m[1])
}

