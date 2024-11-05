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
