/*
Варіант 6
Створіть локальну функцію в межах функції-розширення
для колекцій, яка видаляє дублікати елементів.
*/

fun <T> Collection<T>.removeDuplicates(): List<T> {
    return this.distinct()
}

fun main() {
    val list = listOf(1, 2, 2, 3, 4, 4, 5)
    val uniqueList = list.removeDuplicates()
    println(uniqueList)
}
