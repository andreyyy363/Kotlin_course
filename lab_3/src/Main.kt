interface Course {
    val title: String
    val duration: Int

    fun start()
    fun complete()
    fun fetchProgress(): Double
}

abstract class BaseCourse(override val title: String, override val duration: Int) : Course {
    private var progress: Double = 0.0
    private var isCompleted: Boolean = false

    override fun start() {
        println("Course $title started.")
    }

    abstract fun interact()

    override fun complete() {
        isCompleted = true
        progress = 100.0
        println("Course $title completed.")
    }

    override fun fetchProgress(): Double {
        return progress
    }
}

class VideoCourse(title: String, duration: Int) : BaseCourse(title, duration) {
    override fun interact() {
        println("Watching video for course $title.")
    }
}

class InteractiveCourse(title: String, duration: Int) : BaseCourse(title, duration) {
    override fun interact() {
        println("Interacting with course $title.")
    }
}

class Workshop(title: String, duration: Int) : BaseCourse(title, duration) {
    override fun interact() {
        println("Participating in workshop $title.")
    }
}

fun validateCourse(course: Course) {
    require(course.title.isNotEmpty()) { "Course title cannot be empty" }
    require(course.duration > 0) { "Course duration must be positive" }
}

fun logOperation(operation: String) {
    println("LOG: $operation")
}

fun main() {
    try {
        val videoCourse = VideoCourse("Kotlin Basics", 120)
        validateCourse(videoCourse)
        logOperation("Starting video course")
        videoCourse.start()
        videoCourse.interact()
        videoCourse.complete()
        println("Progress: ${videoCourse.fetchProgress()}%")

        val interactiveCourse = InteractiveCourse("Advanced Kotlin", 180)
        validateCourse(interactiveCourse)
        logOperation("Starting interactive course")
        interactiveCourse.start()
        interactiveCourse.interact()
        interactiveCourse.complete()
        println("Progress: ${interactiveCourse.fetchProgress()}%")

        val workshop = Workshop("Kotlin Workshop", 240)
        validateCourse(workshop)
        logOperation("Starting workshop")
        workshop.start()
        workshop.interact()
        workshop.complete()
        println("Progress: ${workshop.fetchProgress()}%")
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}