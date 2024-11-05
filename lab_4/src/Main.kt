/*
Варіант 19
Створіть функцію, яка приймає список чисел і повертає список чисел,
які є добутком трьох інших чисел зі списку.
 */

fun getProductsOfThreeOthers(numbers: List<Int>): List<Int> {
    return List(numbers.size) { index ->
        numbers.filterIndexed { i, _ -> i != index }
            .reduce { acc, n -> acc * n }
    }
}

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    println(getProductsOfThreeOthers(numbers))
}
