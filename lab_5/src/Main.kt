/*
Варіант 1
Створіть клас "Користувач", який має ім'я (String), вік (Int?), імейл
(String?) та адресу (String?). Реалізуйте функцію, яка виводить інформацію про
користувача, ігноруючи null значення.
 */

// Клас "Користувач"
data class User(
    val name: String,
    val age: Int?,
    val email: String?,
    val address: String?
)

// Функція для виведення інформації про користувача
fun printUserInfo(user: User) {
    println("Інформація про користувача:")

    // Виводимо лише ті поля, які не є null
    println("Ім'я: ${user.name}")
    user.age?.let { println("Вік: $it") }
    user.email?.let { println("Електронна пошта: $it") }
    user.address?.let { println("Адреса: $it") }
}

fun main() {
    // Створення об'єкта користувача
    val user = User(
        name = "Олександр",
        age = null,
        email = "alex@gmail.com",
        address = null
    )

    // Виклик функції для виведення інформації
    printUserInfo(user)
}
